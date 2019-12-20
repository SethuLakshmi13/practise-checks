package com.cognizant.movieservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="movie_list")
public class Movies {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mo_id",columnDefinition = "INT")
	private long id;
	@Column(name="mo_title")
	private String title;
	@Column(name="mo_box_office",columnDefinition = "BIGINT")
	private long boxOffice;
	@Column(name="mo_active",columnDefinition = "VARCHAR(3)")
	private String active;
	@Column(name="mo_date_of_launch")
	private Date dateOfLaunch;
	@Column(name="mo_genre")
	private String genre;
	@Column(name="mo_has_teaser",columnDefinition = "VARCHAR(3)")
	private String hasTeaser;
	@Column(name="mo_image")
	private String image;
	@Column(name="mo_description",columnDefinition = "TEXT")
	private String description;
	@Column(name="mo_rating")
	private String rating;
	@Column(name="mo_language")
	private String language;
	@Column(name="mo_runtime")
	private String runtime;
	@Column(name="mo_like")
	private String like;
	@Column(name="mo_trailer")
	private String trailer;
	
	public Movies() {
		
	}

	public Movies(long id, String title, long boxOffice, String active, Date dateOfLaunch, String genre,
			String hasTeaser, String image, String description, String rating, String language, String runtime,
			String like, String trailer) {
		this.id = id;
		this.title = title;
		this.boxOffice = boxOffice;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.genre = genre;
		this.hasTeaser = hasTeaser;
		this.image = image;
		this.description = description;
		this.rating = rating;
		this.language = language;
		this.runtime = runtime;
		this.like = like;
		this.trailer = trailer;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getBoxOffice() {
		return boxOffice;
	}

	public void setBoxOffice(long boxOffice) {
		this.boxOffice = boxOffice;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getHasTeaser() {
		return hasTeaser;
	}

	public void setHasTeaser(String hasTeaser) {
		this.hasTeaser = hasTeaser;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getLike() {
		return like;
	}

	public void setLike(String like) {
		this.like = like;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + (int) (boxOffice ^ (boxOffice >>> 32));
		result = prime * result + ((dateOfLaunch == null) ? 0 : dateOfLaunch.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((hasTeaser == null) ? 0 : hasTeaser.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((like == null) ? 0 : like.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((runtime == null) ? 0 : runtime.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((trailer == null) ? 0 : trailer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movies other = (Movies) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (boxOffice != other.boxOffice)
			return false;
		if (dateOfLaunch == null) {
			if (other.dateOfLaunch != null)
				return false;
		} else if (!dateOfLaunch.equals(other.dateOfLaunch))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (hasTeaser == null) {
			if (other.hasTeaser != null)
				return false;
		} else if (!hasTeaser.equals(other.hasTeaser))
			return false;
		if (id != other.id)
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (like == null) {
			if (other.like != null)
				return false;
		} else if (!like.equals(other.like))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (runtime == null) {
			if (other.runtime != null)
				return false;
		} else if (!runtime.equals(other.runtime))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (trailer == null) {
			if (other.trailer != null)
				return false;
		} else if (!trailer.equals(other.trailer))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Movies [id=" + id + ", title=" + title + ", boxOffice=" + boxOffice + ", active=" + active
				+ ", dateOfLaunch=" + dateOfLaunch + ", genre=" + genre + ", hasTeaser=" + hasTeaser + ", image="
				+ image + ", description=" + description + ", rating=" + rating + ", language=" + language
				+ ", runtime=" + runtime + ", like=" + like + ", trailer=" + trailer + "]";
	}

}
