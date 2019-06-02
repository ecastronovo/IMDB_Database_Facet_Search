CREATE TABLE Movies (
	id varchar(12),
	title varchar(200),
	year int,
	rtAllCriticsRating float,
	rtAllCriticsNumReviews int,
	rtTopCriticsRating float, 
	rtTopCriticsNumReviews int,
	rtAudienceRating float, 
	rtAudienceNumRatings int,
	Primary Key(id)
);


CREATE TABLE Tags (
	id varchar(12),
	value varchar(50),
	Primary Key(id)
);


CREATE TABLE Genres (
	movieID varchar(12),
	genre varchar(20),
	FOREIGN KEY(movieID) REFERENCES Movies(id) ON DELETE SET NULL
);

CREATE TABLE Countries (
	movieID varchar(12),
	country varchar(40),
	FOREIGN KEY(movieID) REFERENCES Movies(id) ON DELETE SET NULL
);

CREATE TABLE Locations (
movieID varchar(12),
location1 varchar(70),
FOREIGN KEY(movieID) REFERENCES Movies(id) ON DELETE SET NULL
);

CREATE TABLE MovieTags (
	movieID varchar(12),
	tagID varchar(12),
	tagWeight int,
	FOREIGN KEY(movieID) REFERENCES Movies(id) ON DELETE SET NULL,
	FOREIGN KEY(tagID) REFERENCES Tags(id) ON DELETE SET NULL
);

CREATE INDEX iGenres ON Genres(genre);
CREATE INDEX iYears ON Movies(year);
CREATE INDEX iCountries ON Countries(country);
CREATE INDEX iLocations ON Locations(location1);
CREATE INDEX iRating ON Movies(rtAllCriticsRating);
CREATE INDEX iReviews ON Movies(rtAllCriticsNumReviews);