package pt.uporto.les.petcare.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.uporto.les.petcare.model.Pet;
import pt.uporto.les.petcare.model.Sitting;
import pt.uporto.les.petcare.model.dto.input.SittingInputDto;
import pt.uporto.les.petcare.model.dto.output.SittingOutputDto;
import pt.uporto.les.petcare.model.user.PetOwner;
import pt.uporto.les.petcare.model.user.PetSitter;
import pt.uporto.les.petcare.repository.SittingRepository;

@Service
public class SittingService {

    @Autowired
	private SittingRepository sittingRepository;

	@Autowired
	private PetOwnerService petOwnerService;

	@Autowired
	private PetSitterService petSitterService;

	@Autowired
	private PetService petService;

	public SittingOutputDto sendRequest(SittingInputDto sittingInfo) {
		PetOwner petOwner = petOwnerService.findById(sittingInfo.getPetOwnerId())
				.orElseThrow(() -> new RuntimeException("Invalid pet owner."));
		PetSitter petSitter = petSitterService.findById(sittingInfo.getPetSitterId())
				.orElseThrow(() -> new RuntimeException("Invalid pet sitter."));
		Pet pet = petService.findById(sittingInfo.getPetId()).orElseThrow(() -> new RuntimeException("Invalid pet."));
		Sitting newSitting = null;
		if (checkSittingDates(sittingInfo) && checkSittingPetOwner(pet, petOwner)) {
			newSitting = new Sitting(pet, petSitter, sittingInfo.getStartDate(), sittingInfo.getEndDate());
			sittingRepository.save(newSitting);
		}
		SittingOutputDto sittingOutput = null;
		if (newSitting != null) {
			sittingOutput = new SittingOutputDto(newSitting);
		}
		return sittingOutput;
    }

	public SittingOutputDto acceptRequest(long id) {
		Sitting sitting = sittingRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Sitting id not found."));
		;
		if (startsInTheFuture(sitting.getStartDate()) && sitting.acceptRequest()) {
			sittingRepository.save(sitting);
		} else {
			throw new RuntimeException("Sitting already answered.");
		}
		return new SittingOutputDto(sitting);
	}

	public SittingOutputDto rejectRequest(long id) {
		Sitting sitting = sittingRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Sitting id not found."));
		;
		if (startsInTheFuture(sitting.getStartDate()) && sitting.rejectRequest()) {
			sittingRepository.save(sitting);
		} else {
			throw new RuntimeException("Sitting already answered.");
		}
		return new SittingOutputDto(sitting);
	}

	public List<SittingOutputDto> findSittingsByPetSitterId(Long id) {
		List<Sitting> sittings = sittingRepository.findByPetSitterId(id);
		return convertSittingsToDto(sittings);
	}

	public List<SittingOutputDto> findSittingsByPetOwnerId(Long id) {
		List<Sitting> sittings = sittingRepository.findByPetPetOwnerId(id);
		return convertSittingsToDto(sittings);
	}

	private List<SittingOutputDto> convertSittingsToDto(List<Sitting> sittings) {
		List<SittingOutputDto> sittingOutputs = new ArrayList<SittingOutputDto>();
		for (Sitting sitting: sittings) {
			sittingOutputs.add(new SittingOutputDto(sitting));
		}
		return sittingOutputs;
	}

	private boolean checkSittingDates(SittingInputDto sittingInfo) {
		boolean valid = true;
		if (!startsInTheFuture(sittingInfo.getStartDate())
				|| !sittingInfo.getEndDate().isAfter(sittingInfo.getStartDate())) {
			throw new RuntimeException("Invalid dates.");
		}
		return valid;
	}
	
	private boolean startsInTheFuture(LocalDate startDate) {
		return startDate.isAfter(LocalDate.now());
	}

	private boolean checkSittingPetOwner(Pet pet, PetOwner petOwner) {
		boolean valid = true;
		if (pet.getPetOwner().getId() != petOwner.getId()) {
			throw new RuntimeException("The pet doesn't belong to this pet owner.");
		}
		return valid;
	}
}
