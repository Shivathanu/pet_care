package pt.uporto.les.petcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pt.uporto.les.petcare.model.dto.input.SittingInputDto;
import pt.uporto.les.petcare.model.dto.output.SittingOutputDto;
import pt.uporto.les.petcare.service.SittingService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class SittingController {

	@Autowired
	private SittingService sittingService;
	
// 	@CrossOrigin(origins = "*", maxAge = 3600)
	@PostMapping(value = "/api/sitting/request", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> sendRequest(@RequestBody SittingInputDto sittingInfo) {
		ResponseEntity response = null;
		try {
			SittingOutputDto sittingSaved = this.sittingService.sendRequest(sittingInfo);
			response = ResponseEntity.ok(sittingSaved);
		} catch (RuntimeException e) {
			response = response.badRequest().body(e.getMessage());
		}
		return response;
	}

// 	@CrossOrigin(origins = "*", maxAge = 3600)
	@PutMapping(value = "/api/sitting/{sittingId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> acceptRequest(@PathVariable("sittingId") Long sittingId) {
		ResponseEntity response = null;
		try {
			SittingOutputDto sittingAccepted = this.sittingService.acceptRequest(sittingId);
			response = ResponseEntity.ok(sittingAccepted);
		} catch (RuntimeException e) {
			response = response.badRequest().body(e.getMessage());
		}
		return response;
	}

// 	@CrossOrigin(origins = "*", maxAge = 3600)
	@PutMapping(value = "/api/sitting/reject/{sittingId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> rejectRequest(@PathVariable("sittingId") Long sittingId) {
		ResponseEntity response = null;
		try {
			SittingOutputDto sittingRejected = this.sittingService.rejectRequest(sittingId);
			response = ResponseEntity.ok(sittingRejected);
		} catch (RuntimeException e) {
			response = response.badRequest().body(e.getMessage());
		}
		return response;
	}

// 	@CrossOrigin(origins = "*", maxAge = 3600)
	@GetMapping(value = "/api/sitting/sitter/{petSitterId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SittingOutputDto> findSittingByPetSitterId(@PathVariable("petSitterId") Long petSitterId) {
		return sittingService.findSittingsByPetSitterId(petSitterId);
	}

// 	@CrossOrigin(origins = "*", maxAge = 3600)
	@GetMapping(value = "/api/sitting/owner/{petOwnerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SittingOutputDto> findSittingByPetOwnerId(@PathVariable("petOwnerId") Long petOwnerId) {
		return sittingService.findSittingsByPetOwnerId(petOwnerId);
	}
}
