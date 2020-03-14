package pt.uporto.les.petcare.model.dto.input;

import pt.uporto.les.petcare.model.user.PetOwner;
import pt.uporto.les.petcare.model.user.Region;
import pt.uporto.les.petcare.repository.RegionRepository;

public class PetOwnerInputDto {

	private long id;

	private String email;

	private String name;

	private String mobile;

	private String password;

	private Region region;

	private String image;

	private String comment;

	public PetOwnerInputDto() {
	}

	public PetOwnerInputDto(long id, String email, String name, String mobile, String password, Region region,
			String image, String comment) {
		this.email = email;
		this.name = name;
		this.mobile = mobile;
		this.password = password;
		this.region = region;
		this.image = image;
		this.comment = comment;
	}

	public PetOwner build(RegionRepository regionRepository) {

		PetOwner petOwner = new PetOwner();
		petOwner.setId(this.id);
		petOwner.setEmail(this.email);
		petOwner.setName(this.name);
		petOwner.setMobile(this.mobile);
		petOwner.setPassword(this.password);
		petOwner.setImage(this.image);
		petOwner.setComment(this.comment);
		petOwner.setRegion(regionRepository.findByName(this.region.getName()).orElse(null));

		return petOwner;
	}

	public PetOwner build() {
		PetOwner petOwner = new PetOwner();
		petOwner.setId(this.id);
		petOwner.setEmail(this.email);
		petOwner.setName(this.name);
		petOwner.setMobile(this.mobile);
		petOwner.setPassword(this.password);
		petOwner.setImage(this.image);
		petOwner.setComment(this.comment);
		// petOwner.setRegion();

		return petOwner;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}
}
