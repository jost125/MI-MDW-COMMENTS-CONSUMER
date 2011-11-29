package comments.model.entities;

import javax.persistence.Id;

public class ThreadHasTag {
	
	@Id
	private Long id;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
}
