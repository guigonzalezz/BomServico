package com.example.demo.bd.entidade;

public class ImagemAnuncio {
	
	private int id;
	private int anuncio_id;
	private String path;
	
	public ImagemAnuncio() {
		super();
	}
	public ImagemAnuncio(int id, int anuncio_id, String path) {
		super();
		this.id = id;
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
