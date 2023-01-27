package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "messages")
public class MessageModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "message_id")
	private int messageId;
	
	@Column(name = "name")
	private String messages;

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}
}
