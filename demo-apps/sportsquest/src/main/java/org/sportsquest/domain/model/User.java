package org.sportsquest.domain.model;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.support.index.IndexType;

@NodeEntity
public class User extends BaseEntity{
	
	@Size(min = 3, max = 20)
    @Indexed(indexType = IndexType.FULLTEXT, indexName = "search")
	private String username;
	
	@Email
	@Indexed(unique = true, indexType = IndexType.FULLTEXT, indexName = "search")
	private String emailaddress;
	
    User() {}

	public User(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@RelatedTo(type="PEER", direction=Direction.BOTH)
    private @Fetch Set<User> peers = new HashSet<User>();

	public String getUsername() {
		return username;
	}

	public void addPeer(User peer) {
		peers.add(peer);
	}

	public Set<User> getPeers() {
		return peers;
	}

	public String getEmailaddress() {
		return emailaddress;
	}
}
