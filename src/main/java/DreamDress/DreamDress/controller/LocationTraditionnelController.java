package DreamDress.DreamDress.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import DreamDress.DreamDress.Service.LocationTraditionnelService;
import DreamDress.DreamDress.dto.LocationTraditionnelDto;
import DreamDress.DreamDress.model.LocationTraditionnel;
import DreamDress.DreamDress.repository.LocationTraditionnelRepository;

@RestController
@RequestMapping("/locationTraditionnel")
@CrossOrigin

public class LocationTraditionnelController {
	@Autowired
	LocationTraditionnelService locationTraditionnelService;

	// Get All()
	@GetMapping()
	public List<LocationTraditionnel> findAll() {
		return locationTraditionnelService.findAll();
	}

	// Gety id()
	@GetMapping(path="/{id}")
	public LocationTraditionnel findOne(@PathVariable(required = true) Long id) {
		return locationTraditionnelService.findOne(id);
	}

	// creer une location robe traditionnel
	@PostMapping
	public LocationTraditionnel save(@Valid  @RequestBody	LocationTraditionnelDto locationTraditionnelDto)
			throws IllegalStateException, IOException {
		return locationTraditionnelService.save(locationTraditionnelDto);
	}

	// Update()
	@PutMapping("/{id}")
	public LocationTraditionnel update(@Valid @RequestBody LocationTraditionnelDto locationTraditionnelDto,
			 @PathVariable(required = true) Long id)
			throws IllegalStateException, IOException {
		return locationTraditionnelService.update(id, locationTraditionnelDto);
	}
	

	// delete by id
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(required = true) Long id) throws IOException {
		locationTraditionnelService.delete(id);
	}

}
