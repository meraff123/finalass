package Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Domain.Channel;
import Domain.Message;
import repository.ChannelRepository;
import repository.MessageRepository;

@Service
public class MessageService {

  private final MessageRepository messageRepository;
  private final ChannelRepository channelRepository;

  @Autowired
  public MessageService(MessageRepository messageRepository, ChannelRepository channelRepository) {
    this.messageRepository = messageRepository;
    this.channelRepository = channelRepository;
  }

  public List<Message> getMessagesByChannel(Long channelId) {
	return null;
  }

  public void addMessageToChannel(Message message) {
    Channel channel = channelRepository.findById(message.getChannelId());
    List<Message> messagesByChannel = getMessagesByChannel(message.getChannelId());
    messagesByChannel.add(message);
  }

}
