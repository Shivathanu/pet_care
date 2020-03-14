package pt.uporto.les.petcare.model.dto.output;

import pt.uporto.les.petcare.model.user.PetSitter;

import java.util.List;
import java.util.stream.Collectors;

public class PetSitterOutputDto {

	private long id;

	private String email;

	private String name;

	private String mobile;

	private String image;

	private String region;

	private String comment;

	public PetSitterOutputDto() {
	}

	public PetSitterOutputDto(PetSitter petSitter) {
		this.id = petSitter.getId();
		this.email = petSitter.getEmail();
		this.name = petSitter.getName();
		this.mobile = petSitter.getMobile();
		this.image = petSitter.getImage();
		this.region = (petSitter.getRegion() != null ? petSitter.getRegion().getName() : "");
		this.comment = petSitter.getComment();
	}

	public long getId() {
		return id;
	}

	public String getComment() {
		return comment;
	}

	public static List<PetSitterOutputDto> listFrom(List<PetSitter> original) {
		return original.stream().map(PetSitterOutputDto::new).collect(Collectors.toList());
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getMobile() {
		return mobile;
	}

	public String getRegion() {
		return region;
	}

	public String getImage() {
		return image;
	}
}
