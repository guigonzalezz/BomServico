package com.bomservico.model;

public class ImagemAnuncio {
	
	private Long id;
	private Long anuncio_id;
	private String path;

	public ImagemAnuncio() {
		super();
	}

	public ImagemAnuncio(Long anuncio_id, String path) {
		super();
		this.anuncio_id = anuncio_id;
		this.path = path;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAnuncioId() {
		return anuncio_id;
	}

	public void setAnuncioId(Long anuncio_id) {
		this.anuncio_id = anuncio_id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
