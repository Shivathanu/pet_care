package pt.uporto.les.petcare.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import pt.uporto.les.petcare.model.user.PetSitter;

@Entity
public class Sitting extends AbstractEntity {

	@ManyToOne
	private Pet pet;

	@ManyToOne
	private PetSitter petSitter;

	private LocalDate startDate;

	private LocalDate endDate;

	// reviews

	private String state;

	public Sitting(Pet pet, PetSitter petSitter, LocalDate startDate, LocalDate endDate, String state) {
		super();
		this.pet = pet;
		this.petSitter = petSitter;
		this.startDate = startDate;
		this.endDate = endDate;
		this.state = state;
	}

	public Sitting(Pet pet, PetSitter petSitter, LocalDate startDate, LocalDate endDate) {
		this(pet, petSitter, startDate, endDate, "REQUEST");
	}

	public Sitting() {
	}

	// State related methods
	public boolean checkIsRequest() {
		return state.equals("REQUEST");
	}

	public boolean checkIsAccepted() {
		return state.equals("ACCEPTED");
	}

	public boolean checkIsRejected() {
		return state.equals("REJECTED");
	}

	public boolean checkIsFinished() {
		return state.equals("FINISHED");
	}

	public boolean acceptRequest() {
		return acceptOrReject("ACCEPTED");
	}

	public boolean rejectRequest() {
		return acceptOrReject("REJECTED");
	}

	private boolean acceptOrReject(String newState) {
		boolean success = false;
		if (checkIsRequest()) {
			state = newState;
			success = true;
		}
		return success;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public PetSitter getPetSitter() {
		return petSitter;
	}

	public void setPetSitter(PetSitter petSitter) {
		this.petSitter = petSitter;
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
		return "Sitting [pet=" + pet + ", petSitter=" + petSitter + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", getPet()=" + getPet() + ", getPetSitter()=" + getPetSitter() + ", getStartDate()=" + getStartDate()
				+ ", getEndDate()=" + getEndDate() + ", getId()=" + getId() + ", hashCode()=" + hashCode()
				+ ", getCreateDateTime()=" + getCreateDateTime() + ", getUpdateDateTime()=" + getUpdateDateTime()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + "]";
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
