package pt.uporto.les.petcare.model.dto.output;

import java.time.LocalDate;

import pt.uporto.les.petcare.model.Sitting;
import pt.uporto.les.petcare.model.dto.input.PetInputDto;

public class SittingOutputDto {

	private Long id;

	private PetInputDto pet;

	private PetSitterOutputDto petSitter;

	private LocalDate startDate;

	private LocalDate endDate;

	private String state;

	// reviews

	public SittingOutputDto(Long id, PetInputDto pet, PetSitterOutputDto petSitter, LocalDate startDate,
			LocalDate endDate,
			String state) {
		super();
		this.id = id;
		this.pet = pet;
		this.petSitter = petSitter;
		this.startDate = startDate;
		this.endDate = endDate;
		this.state = state;
	}

	public SittingOutputDto(Sitting sitting) {
		this.id = sitting.getId();
		this.pet = new PetInputDto(sitting.getPet());
		this.petSitter = new PetSitterOutputDto(sitting.getPetSitter());
		this.startDate = sitting.getStartDate();
		this.endDate = sitting.getEndDate();
		this.state = sitting.getState();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PetInputDto getPet() {
		return pet;
	}

	public void setPet(PetInputDto pet) {
		this.pet = pet;
	}

	public PetSitterOutputDto getPetSitter() {
		return petSitter;
	}

	public void setPetSitter(PetSitterOutputDto petSitter) {
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	}
