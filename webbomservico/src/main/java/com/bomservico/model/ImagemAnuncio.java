package com.bomservico.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ImagemAnuncio {
	@NotNull
	private int id;

	@NotNull
	private int anuncio_id;

	@NotNull
	@NotBlank
	private String path;

	public ImagemAnuncio() {
		super();
	}

	public ImagemAnuncio(@NotNull int anuncio_id, @NotNull @NotBlank String path) {
		super();
		this.anuncio_id = anuncio_id;
		this.path = path;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAnuncioId() {
		return anuncio_id;
	}

	public void setAnuncioId(int anuncio_id) {
		this.anuncio_id = anuncio_id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
