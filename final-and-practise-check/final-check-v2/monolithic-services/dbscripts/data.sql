-- Include table data insertion, updation, deletion and select scripts
insert into movie_list(mo_id, mo_title, mo_box_office, mo_active, mo_date_of_launch, mo_genre, mo_has_teaser,mo_image,mo_description,mo_rating,mo_language,mo_runtime,mo_like,mo_trailer)
values(1,'Avatar',2787965087,'Yes','2017/03/15','Science Fiction','Yes','https://upload.wikimedia.org/wikipedia/en/b/b0/Avatar-Teaser-Poster.jpg',
'Avatar is a science fiction film written and directed by James Cameron. In this movie Jake, a paraplegic marine, replaces his brother on the Navi
 inhabited Pandora for a corporate mission.He is accepted by the natives as one of their own but he must decide where his loyalties lie.
 His choice of Loyatily is the major turn in the movie','U/A','English','2.41.44','88','https://www.youtube.com/embed/5PSNL1qE6VY'),
(2,'The Avengers',1518812988,'Yes','2017/12/23','Superhero','No','https://cdn.shopify.com/s/files/1/1148/2822/products/PBMAAOU088_1024x1024.jpg?v=1510903066',
'The Marvel Cinematic Universe (MCU) films are a series of American superhero films producedby Marvel Studios based on characters that appear in publications 
 by Marvel Comics.The MCU is the shared universe in which all of the films are set.It is a superhero movie based on Adventures','U/A','English','2.23.00','90',
 'https://www.youtube.com/embed/eOrNdBpGMv8'),
(3,'Titanic',2187463944,'Yes','2017/08/21','Romance','No','https://d1w8cc2yygc27j.cloudfront.net/376890639361779221/-964579459415210037.jpg',
'Seventeen-year-old Rose hails from an aristocratic family and is set to be marriedWhen she boards the Titanic, she meets Jack Dawson, an artist,
 and falls in love with him.The director felt a love story interspersed with the human loss would be essential to convey the emotional impact of the disaster.',
 'A','English','3.15.00','95','https://www.youtube.com/embed/2e-eXJ6HgkQ'),
(4,'Jurassic World',1671713208,'No','2017/07/02','Science Fiction','Yes','https://images.fineartamerica.com/images/artworkimages/mediumlarge/1/jurassic-world-5-movie-poster-prints.jpg',
'The Jurassic World luxury resort provides a habitat for an array of genetically engineered dinosaursincluding the vicious and intelligent Indominus rex.
 When the massive creature escapes,causes disaster Now, it is up to a former military man and animal expert (Chris Pratt) to use his special skills to save the people.',
'U','English','2.4.00','80','https://www.youtube.com/embed/RFinNxS5KN4'),
(5,'Avengers:End Game',2750760348,'Yes','2022/11/02','Superhero','Yes','https://img.purch.com/o/aHR0cDovL3d3dy5uZXdzYXJhbWEuY29tL2ltYWdlcy9pLzAwMC8yNTMvMDQ3L2kwMi9FbmRnYW1lX09kZW9uX0xlZnQuanBlZw==',
'Thanos used the Infinity Gauntlet to disintegrate half of all life in the universeTony Stark and Nebula from deep space and returns them to Earth
 where they reunite with the remaining Avengers.They plan to retake and use the Infinity Stones to reverse the Snap but Thanos reveals he destroyed the Stones 
 to prevent their further use','U','English','3.2.00','92','https://www.youtube.com/embed/TcMBFSGVi1c');

insert into user(us_name,us_password,us_first_name,us_last_name)
values('admin','$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK','admin','admin'),('user','$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK','user','user');

insert into role(ro_name)
values('admin'),('user');

insert into user_role(ur_us_id,ur_ro_id)
values(1,1),(2,2);

insert into genre(ge_name)
values('Superhero'),('Romance'),('Science Fiction'),('Adventure'),('Comedy');

select mo_id, mo_title, mo_box_office, mo_active, mo_date_of_launch, mo_genre, mo_has_teaser ,mo_image,mo_description,mo_rating,mo_language,mo_runtime,mo_like,mo_trailer
from movie_list;

select mo_id, mo_title, mo_box_office, mo_active, mo_date_of_launch, mo_genre, mo_has_teaser ,mo_image,mo_description,mo_rating,mo_language,mo_runtime,mo_like,mo_trailer
from movie_list 
where mo_date_of_launch <= (select curdate()) and mo_active = 'yes';

select mo_title, mo_box_office, mo_active, mo_date_of_launch, mo_genre, mo_has_teaser 
from movie_list 
where mo_id = 1;


select movie_list.mo_id, movie_list.mo_title, movie_list.mo_box_office, movie_list.mo_genre, movie_list.mo_has_teaser 
from movie_list 
left join favorite 
on movie_list.mo_id = favorite.fa_mo_id 
where favorite.fa_us_id = 1;

select count(fa_mo_id) as no_of_favorites 
from favorite 
group by favorite.fa_us_id;

drop table genre;

