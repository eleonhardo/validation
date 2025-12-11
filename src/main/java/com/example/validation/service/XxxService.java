package com.example.validation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.validation.web.XxxCreateRequest;

import jakarta.validation.Valid;

@Service
public class XxxService {
	private final XxxInMemoryRepository repository;

	public XxxService(XxxInMemoryRepository repository) {
		this.repository = repository;
	}

	public List<Xxx> findByName(String term) {
		return repository.findByNameIgnoreCaseContains(term);
	}

	public List<Xxx> findAll() {
		return repository.findAll();
	}

	public Xxx findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new XxxNotFoundException(id));
	}

	public Xxx create(@Valid XxxCreateRequest request) {
		Xxx entity = new Xxx();
		entity.setName(request.getName());
		entity.setYyyId(request.getYyyId());
		return repository.save(entity);
	}

	public Xxx update(Long id, @Valid XxxCreateRequest xxxUpdateRequest) {
		Xxx existing = findById(id);
		existing.setName(xxxUpdateRequest.getName());
		existing.setYyyId(xxxUpdateRequest.getYyyId());
		return repository.save(existing);
	}

	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new XxxNotFoundException(id);
		}
		repository.deleteById(id);
	}
}
