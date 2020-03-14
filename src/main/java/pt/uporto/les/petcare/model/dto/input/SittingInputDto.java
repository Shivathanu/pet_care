package pt.uporto.les.petcare.model.dto.input;

import java.time.LocalDate;

public class SittingInputDto {

	private long petId;

	private long petOwnerId;

	private long petSitterId;

	private LocalDate startDate;

	private LocalDate endDate;

	public SittingInputDto(long petId, long petOwnerId, long petSitterId, LocalDate startDate, LocalDate endDate) {
		super();
		this.petId = petId;
		this.petOwnerId = petOwnerId;
		this.petSitterId = petSitterId;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public SittingInputDto() {
	}

	public long getPetId() {
		return petId;
	}

	public void setPetId(long petId) {
		this.petId = petId;
	}

	public long getPetOwnerId() {
		return petOwnerId;
	}

	public void setPetOwnerId(long petOwnerId) {
		this.petOwnerId = petOwnerId;
	}

	public long getPetSitterId() {
		return petSitterId;
	}

	public void setPetSitterId(long petSitterId) {
		this.petSitterId = petSitterId;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Sitting [petId=" + petId + ", petOwnerId=" + petOwnerId + ", petSitterId=" + petSitterId
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", getPetId()=" + getPetId()
				+ ", getPetOwnerId()=" + getPetOwnerId() + ", getPetSitterId()=" + getPetSitterId()
				+ ", getStartDate()=" + getStartDate() + ", getEndDate()=" + getEndDate() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
