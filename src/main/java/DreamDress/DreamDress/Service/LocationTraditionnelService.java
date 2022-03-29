package DreamDress.DreamDress.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import DreamDress.DreamDress.dto.LocationTraditionnelDto;
import DreamDress.DreamDress.model.LocationTraditionnel;
import DreamDress.DreamDress.repository.LocationTraditionnelRepository;

@Service
public class LocationTraditionnelService {
	@Autowired
	LocationTraditionnelRepository locationTraditionnelRepository;

	// récuperer la liste des robe traditionnel en location
	public List<LocationTraditionnel> findAll() {
		return locationTraditionnelRepository.findAll();
	}

	// recuperer une seul robe par son id
	public LocationTraditionnel findOne(Long id) {
		Optional<LocationTraditionnel> optLocationTraditionnel = locationTraditionnelRepository.findById(id);
		if (optLocationTraditionnel.isPresent()) {
			return optLocationTraditionnel.get();
		} else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

	// creer une robe location traditionnel
	public LocationTraditionnel save(LocationTraditionnelDto locationTraditionnelDto) throws IllegalStateException {
		LocationTraditionnel locationTradionnel = new LocationTraditionnel();
		locationTradionnel.setNom(locationTraditionnelDto.getNom());
		locationTradionnel.setTaille(locationTraditionnelDto.getTaille());
		locationTradionnel.setImage(locationTraditionnelDto.getImage());
		locationTradionnel.setPrix(locationTraditionnelDto.getPrix());
		locationTradionnel.setDescription(locationTraditionnelDto.getDescription());
		return locationTraditionnelRepository.save(locationTradionnel);

	}

	// modifier une robe location traditionnel
	public LocationTraditionnel update(Long id, LocationTraditionnelDto locationTraditionnelDto) throws IOException {
		Optional<LocationTraditionnel> optLocationTraditionnel = locationTraditionnelRepository.findById(id);
		if (optLocationTraditionnel.isPresent()) {
			LocationTraditionnel locationTraditionnel = optLocationTraditionnel.get();
			locationTraditionnel.setNom(locationTraditionnelDto.getNom());
			locationTraditionnel.setTaille(locationTraditionnelDto.getTaille());
			locationTraditionnel.setImage(locationTraditionnelDto.getImage());
			locationTraditionnel.setPrix(locationTraditionnelDto.getPrix());
			locationTraditionnel.setDescription(locationTraditionnelDto.getDescription());
			return locationTraditionnelRepository.save(locationTraditionnel);

		} else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

	// supprimer une robe location traditionnel
	public void delete(Long id) throws IOException {
		Optional<LocationTraditionnel> optLocationTraditionnel = locationTraditionnelRepository.findById(id);
		if (optLocationTraditionnel.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		LocationTraditionnel locationTraditionnel = optLocationTraditionnel.get();
		locationTraditionnelRepository.deleteById(id);
	}

}
