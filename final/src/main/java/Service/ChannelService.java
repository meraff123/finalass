package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import Domain.Channel;
import repository.ChannelRepository;

public class ChannelService {
	

	    @Autowired
	    private ChannelRepository channelRepository;

	    public void createRandomChannel(){
	        channelRepository.createRandomChannel();
	    }

	    public Channel findChannelById(Long channelId) {
	        return channelRepository.findById(channelId);
	    }

	    public List<Channel> findAll() {
	        return channelRepository.findAll();
	    }

	    public void save(String channelName) {
	        channelRepository.save(channelName);
	    }
	}