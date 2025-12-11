package com.example.validation.web;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.example.validation.service.Xxx;

@Component
public class XxxModelAssembler implements RepresentationModelAssembler<Xxx, XxxResponse> {

	@Override
	public XxxResponse toModel(Xxx entity) {
		XxxResponse model = new XxxResponse();
		model.setId(entity.getId());
		model.setName(entity.getName());
		model.setYyyId(entity.getYyyId());

		// Self
		model.add(linkTo(methodOn(XxxController.class).getOne(entity.getId())).withSelfRel());

		// Collection
		model.add(linkTo(methodOn(XxxController.class).getAll()).withRel("xxxs"));

		// Search (templated link)
		model.add(linkTo(methodOn(XxxController.class).findByName(null) // null → wird als URI-Template genutzt
		).withRel("search").expand());

		return model;
	}

	@Override
	public CollectionModel<XxxResponse> toCollectionModel(Iterable<? extends Xxx> entities) {
		CollectionModel<XxxResponse> collectionModel = RepresentationModelAssembler.super.toCollectionModel(entities);

		// Self-Link für die Liste (z.B. beim GET /api/xxxs oder einer Suche)
		collectionModel.add(linkTo(methodOn(XxxController.class).getAll()).withSelfRel());

		// Search auch auf Collection
		collectionModel.add(linkTo(methodOn(XxxController.class).findByName(null)).withRel("search").expand());

		return collectionModel;
	}
}
