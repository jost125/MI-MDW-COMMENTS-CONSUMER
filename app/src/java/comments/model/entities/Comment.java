package comments.model.entities;

import javax.persistence.Id;

public class Comment {

	@Id
	private Long id;
	private String authorName;
	private Boolean blocked;
	private Long createdAt;
	private Integer numberOfAgreements;
	private Integer numberOfDisagreements;
	private String text;

	public Long getId() {
		return id;
	}

	public String getAuthorName() {
		return authorName;
	}

	public Boolean getBlocked() {
		return blocked;
	}

	public Long getCreatedAt() {
		return createdAt;
	}

	public Integer getNumberOfAgreements() {
		return numberOfAgreements;
	}

	public Integer getNumberOfDisagreements() {
		return numberOfDisagreements;
	}

	public String getText() {
		return text;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public void setBlocked(Boolean blocked) {
		this.blocked = blocked;
	}

	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNumberOfAgreements(Integer numberOfAgreements) {
		this.numberOfAgreements = numberOfAgreements;
	}

	public void setNumberOfDisagreements(Integer numberOfDisagreements) {
		this.numberOfDisagreements = numberOfDisagreements;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "{" + id + ", " + authorName + ", " + text + "}";
	}
}
