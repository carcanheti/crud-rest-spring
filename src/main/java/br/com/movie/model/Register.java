package br.com.movie.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.movie.enums.Gender;

@Entity
@Table(name = "register")
public class Register {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name" , length = 255)
	private String name;
	
	@Column(name = "height")
	private Integer height;
	
	@Column(name = "mass")
	private Integer mass;
	
	@Column(name = "hair_color")
	private String hairColor;
	
	@Column(name = "skin_color")
	private String skinColor;
	
	@Column(name = "eye_color")
	private String eyeColor;
	
	@Column(name = "birthYear")
	private String birthYear;
	
	@Column(name = "gender")
	private Gender gender;
	
	@OneToOne(mappedBy = "register", fetch = FetchType.LAZY)
	private HomeWorld homeworld;
	
	@OneToMany(mappedBy = "register")
	private List<Species> listSpecies;
	
	@OneToMany(mappedBy = "register")
	private List<Vehicles> listVehicles;
	
	@OneToMany(mappedBy = "register")
	private List<Starships> listStarships;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Integer getMass() {
		return mass;
	}
	public void setMass(Integer mass) {
		this.mass = mass;
	}
	public String getHairColor() {
		return hairColor;
	}
	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}
	public String getSkinColor() {
		return skinColor;
	}
	public void setSkinColor(String skinColor) {
		this.skinColor = skinColor;
	}
	public String getEyeColor() {
		return eyeColor;
	}
	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}
	public String getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public HomeWorld getHomeworld() {
		return homeworld;
	}
	public void setHomeworld(HomeWorld homeworld) {
		this.homeworld = homeworld;
	}
	public List<Species> getListSpecies() {
		return listSpecies;
	}
	public void setListSpecies(List<Species> listSpecies) {
		this.listSpecies = listSpecies;
	}
	public List<Vehicles> getListVehicles() {
		return listVehicles;
	}
	public void setListVehicles(List<Vehicles> listVehicles) {
		this.listVehicles = listVehicles;
	}
	public List<Starships> getListStarships() {
		return listStarships;
	}
	public void setListStarships(List<Starships> listStarships) {
		this.listStarships = listStarships;
	}
	
}
