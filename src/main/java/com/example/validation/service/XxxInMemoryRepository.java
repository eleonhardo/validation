package com.example.validation.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

@Repository
public class XxxInMemoryRepository {

	private final Map<Long, Xxx> store = new HashMap<>();
	private final AtomicLong idGenerator = new AtomicLong(1);

	public List<Xxx> findByNameIgnoreCaseContains(String term) {
		if (term == null || term.isBlank()) {
			return List.of();
		}

		String normalized = term.toLowerCase();

		return store.values().stream()
				.filter(x -> x.getName() != null && x.getName().toLowerCase().contains(normalized)).toList();
	}

	// --- CRUD-Like API ---

	public List<Xxx> findAll() {
		return new ArrayList<>(store.values());
	}

	public Optional<Xxx> findById(Long id) {
		return Optional.ofNullable(store.get(id));
	}

	public Xxx save(Xxx xxx) {
		if (xxx.getId() == null) {
			long newId = idGenerator.getAndIncrement();
			xxx.setId(newId);
		}
		store.put(xxx.getId(), xxx);
		return xxx;
	}

	public boolean existsById(Long id) {
		return store.containsKey(id);
	}

	public void deleteById(Long id) {
		store.remove(id);
	}
}
