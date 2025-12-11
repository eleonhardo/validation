package com.example.validation.web;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.validation.service.Xxx;
import com.example.validation.service.XxxService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/xxxs")
public class XxxController {

	private final XxxService service;
	private final XxxModelAssembler assembler;
	private final XxxCreateValidator createValidator;

	public XxxController(XxxService service, XxxModelAssembler assembler, XxxCreateValidator createValidator) {
		this.service = service;
		this.assembler = assembler;
		this.createValidator = createValidator;
	}

	@InitBinder("xxxCreateRequest")
	void initBinder(WebDataBinder binder) {
		binder.addValidators(createValidator);
	}

	@GetMapping
	public CollectionModel<XxxResponse> getAll() {
		var xxList = service.findAll();
		return assembler.toCollectionModel(xxList);
	}

	@GetMapping("/search")
	public CollectionModel<XxxResponse> findByName(@RequestParam(required = false) String term) {
		var result = service.findByName(term);
		return assembler.toCollectionModel(result);
	}

	@GetMapping("/{id}")
	public XxxResponse getOne(@PathVariable Long id) {
		Xxx xxx = service.findById(id);
		return assembler.toModel(xxx);
	}

	@PostMapping
	public XxxResponse create(@Valid @RequestBody XxxCreateRequest request) {
		Xxx saved = service.create(request);
		return assembler.toModel(saved);
	}

	@PutMapping("/{id}")
	public XxxResponse update(@PathVariable Long id, @Valid @RequestBody XxxCreateRequest xxxUpdateRequest) {
		Xxx updated = service.update(id, xxxUpdateRequest);
		return assembler.toModel(updated);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
