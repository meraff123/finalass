document.addEventListener("DOMContentLoaded", function() {
    const messageBox = document.getElementById("messageBox");

    messageBox.addEventListener("keydown", function(event) {
        if (event.keyCode === 13) {
            event.preventDefault();
            const message = messageBox.value.trim();
            if (message !== "") {
                sendMessage(message);
                messageBox.value = "";
            }
        }
    });

    setInterval(getMessages, 500);
});

function sendMessage(message) {
    const channelId = getChannelId();
    const user = JSON.parse(sessionStorage.getItem("user"));

    const data = {
        channelId: channelId,
        userId: user.id,
        content: message
    };

    fetch(`/channels/${channelId}/messages`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    }).then(response => response.json())
    .then(message => {
        console.log("Message sent:", message);
    });
}

function getMessages() {
    const channelId = getChannelId();

    fetch(`/channels/${channelId}/messages`)
        .then(response => response.json())
        .then(messages => {
            displayMessages(messages);
        });
}

function displayMessages(messages) {
    const messageContainer = document.querySelector(".message-container");
    messageContainer.innerHTML = "";

    messages.forEach(message => {
        const timestamp = document.createElement("span");
        timestamp.className = "timestamp";
        timestamp.textContent = message.userId + ": ";

        const messageText = document.createElement("span");
        messageText.className = "message";
        messageText.textContent = message.content;

        const messageDiv = document.createElement("div");
        messageDiv.appendChild(timestamp);
        messageDiv.appendChild(messageText);

        messageContainer.appendChild(messageDiv);
    });
}

function getChannelId() {
    const path = window.location.pathname;
    const parts = path.split("/");
    return parts[2];
}
