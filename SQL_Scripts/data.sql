# 1 Tabla role

INSERT INTO `formula1`.`role` (`name`) 
VALUES ('Administrador');

INSERT INTO `formula1`.`role` (`name`) 
VALUES ('Responsable');

#2 Tabla user

INSERT INTO `formula1`.`user` (`email`, `enabled`, `name`, `password`, `user`) 
VALUES ('admin@example.com', 1, 'admin', '$2a$10$oxFmx9ZN1HIxpP2g99bRSufqMcRdJ5TKXDV9sKJeuUal818Su.peO', 'admin');
INSERT INTO `formula1`.`user` (`email`, `enabled`, `name`, `password`, `user`) 
VALUES ('responsable1@example.com', 1, 'responsable1', '$2a$10$GtTETubmhHGeYxPKTefNaOUQ2orlfZRgFcJCQ31OC0Kt2GzfOvomu', 'responsable1');
INSERT INTO `formula1`.`user` (`email`, `enabled`, `name`, `password`, `user`) 
VALUES ('responsable2@example.com', 1, 'responsable2', '$2a$10$GtTETubmhHGeYxPKTefNaOUQ2orlfZRgFcJCQ31OC0Kt2GzfOvomu', 'responsable2');
INSERT INTO `formula1`.`user` (`email`, `enabled`, `name`, `password`, `user`) 
VALUES ('responsable3@example.com', 1, 'responsable3', '$2a$10$GtTETubmhHGeYxPKTefNaOUQ2orlfZRgFcJCQ31OC0Kt2GzfOvomu', 'responsable3');

#3 Tabla users_roles

INSERT INTO `formula1`.`users_roles` (`user_id`, `role_id`)
VALUES (1,1);
INSERT INTO `formula1`.`users_roles` (`user_id`, `role_id`)
VALUES (2,2);
INSERT INTO `formula1`.`users_roles` (`user_id`, `role_id`)
VALUES (3,2);
INSERT INTO `formula1`.`users_roles` (`user_id`, `role_id`)
VALUES (4,2);

#4 Tabla t_noticias

INSERT INTO `formula1`.`t_noticias` (`imagen`, `link`, `texto`, `titulo`) 
VALUES ('http://media-s3-us-east-1.ceros.com/bwin/images/2018/10/18/e1aeb6fe513714a13d3b6d2bdaf5acd0/hamilton-2.png', 'https://es.motorsport.com/f1/news/hamilton-reaparece-redes-sociales-mensaje/7908800/', 'Lewis Hamilton volvió a publicar un mensaje en redes sociales, tras 56 días en silencio. "Me he ido. ¡Ahora estoy de vuelta", publicó junto a una foto.', 'Hamilton reaparece en redes sociales: "¡Estoy de vuelta!"');

INSERT INTO `formula1`.`t_noticias` (`imagen`, `link`, `texto`, `titulo`) 
VALUES ('https://www.grandprix.com.au/uploads/images/_driverProfile/103633/FOR-FANZONE-DRIVER-PROFILES-GP21-Sainz-Detail.png', 'https://es.motorsport.com/f1/news/entrenamiento-carlos-sainz-rutina-cardio-fuerza-sesiones/7906288/', 'El piloto de Ferrari en Fórmula 1, Carlos Sainz, reveló cómo son sus entrenamientos, cuántas sesiones hace, cómo es la dieta y qué actividades realiza.', 'Así es el entrenamiento de Carlos Sainz: rutina, alimentación y más');

INSERT INTO `formula1`.`t_noticias` (`imagen`, `link`, `texto`, `titulo`) 
VALUES ('https://www.autoloctahiti.com/wp-content/uploads/2015/09/logo-mercedes-benz-png.png', 'https://es.motorsport.com/f1/news/mercedes-pistas-w13-2022/7898687/', 'Para recordar la presentación del W13 prevista para el 18 de febrero, Mercedes publicó una imagen muy oscura de un posible F1 de 2022.', '¿Ha desvelado Mercedes detalles del nuevo W13 para F1 2022?');

INSERT INTO `formula1`.`t_noticias` (`imagen`, `link`, `texto`, `titulo`) 
VALUES ('https://cdn.freebiesupply.com/logos/large/2x/fia-4-logo-png-transparent.png', 'https://es.motorsport.com/f1/news/fia-busca-director-general-ceo-proceso-reforma/7875759/', 'El nuevo presidente de la FIA, Mohammed Ben Sulayem, ha dado los primeros pasos en su mandato para reformar el máximo organismo, y continúa buscando un director general.', 'La FIA busca un director general para completar el proceso de reforma');

INSERT INTO `formula1`.`t_noticias` (`imagen`, `link`, `texto`, `titulo`) 
VALUES ('https://www.eitmedia.mx/media/k2/items/cache/40d748d72862b30cf602088ed406af83_XL.jpg', 'https://es.motorsport.com/f1/news/wheatley-ferrari-red-bull-amenaza-temporada-2022/7857477/', 'El director técnico de Red Bull, Jonathan Wheatley, avisa de que Ferrari puede ser el principal rival en 2022, y espera que la investigación de la FIA dé "más consistencia".', 'Red Bull cree que Ferrari será la gran amenaza en la F1 de 2022');

INSERT INTO `formula1`.`t_noticias` (`imagen`, `link`, `texto`, `titulo`) 
VALUES ('https://lemagsportauto.ouest-france.fr/wp-content/uploads/2017/02/vf17_4-e1488117952649-1200x900.png', 'https://es.motorsport.com/f1/news/analisis-tecnico-haas-f1-2022/7873510/', 'Haas ha presentado el primer coche de la Fórmula 1 2022. ¿Qué cambios tiene? ¿qué ideas da de lo que veremos en el resto de la parrilla? Lo analizamos.', '¿Qué ha dejado realmente ver Haas sobre el primer F1 de 2022?');

INSERT INTO `formula1`.`t_noticias` (`imagen`, `link`, `texto`, `titulo`) 
VALUES ('https://dicodusport.fr/blog/wp-content/uploads/2021/03/Red-Bull-RB16B.png', 'https://es.motorsport.com/f1/news/red-bull-no-presentar-coche-definitivo-2022-test/7873470/', 'Red Bull será el segundo equipo en presentar su monoplaza para la temporada 2022 de Fórmula 1, y Helmut Marko aclara que ese no será el coche que estará en los test.', 'Red Bull admite que el coche que presentará no será el de los test');

INSERT INTO `formula1`.`t_noticias` (`imagen`, `link`, `texto`, `titulo`) 
VALUES ('https://static.moniteurautomobile.be/clients/moniteur/content/medias/images/news/39000/300/20/haas_vf-22__3_.png', 'https://es.motorsport.com/f1/news/comparacion-haas-2022-coche-2021/7876397/', '¿En qué se diferencia el Haas VF-22 presentado para la temporada 2022 de F1 de su predecesor, el Haas VF-21 de 2021? ¡Comparamos de manera directa las fotos de los dos coches!', 'Comparación visual: el Haas VF-22 de 2022 vs el de 2021');

INSERT INTO `formula1`.`t_noticias` (`imagen`, `link`, `texto`, `titulo`) 
VALUES ('https://media3.speedcafe.com/wp-content/uploads/2019/11/sam-michael-1.png', 'https://es.motorsport.com/general/news/sam-michael-cambio-comision-seguridad-fia/7875255/', 'El ex director deportivo de McLaren en la Fórmula 1, Sam Michael, estará al frente de la Comisión de Seguridad de la FIA, sustituyendo a Sir Patrick Head.', 'Sam Michael dirigirá la Comisión de Seguridad de la FIA');

INSERT INTO `formula1`.`t_noticias` (`imagen`, `link`, `texto`, `titulo`) 
VALUES ('https://e0.365dm.com/21/03/2048x1152/skysports-f1-car-launches-2021_5294175.png', 'https://es.motorsport.com/f1/news/formula1-2022-fechas-presentaciones/7301540/', 'El Mercedes de Hamilton, el Red Bull de Verstappen, el Alpine de Alonso o el Ferrari de Sainz... ¡No te pierdas ninguna presentación de los nuevos monoplazas de F1 2022!', 'Coches de la F1 2022: fechas de presentaciones de los equipos');

#5 Tabla t_coches

INSERT INTO `formula1`.`t_coches` (`consumo`, `ers_curva_lenta`, `ers_curva_media`, `ers_curva_rapida`,`codigo`, `nombre`) 
VALUES ('38','0.03','0.04','0.03','W13','Mercedes');

INSERT INTO `formula1`.`t_coches` (`consumo`, `ers_curva_lenta`, `ers_curva_media`, `ers_curva_rapida`,`codigo`, `nombre`) 
VALUES ('33','0.06','0.05','0.04','RB18','Red Bull');

INSERT INTO `formula1`.`t_coches` (`consumo`, `ers_curva_lenta`, `ers_curva_media`, `ers_curva_rapida`,`codigo`, `nombre`) 
VALUES ('31','0.03','0.06','0.03','F1-75','Ferrari');

INSERT INTO `formula1`.`t_coches` (`consumo`, `ers_curva_lenta`, `ers_curva_media`, `ers_curva_rapida`,`codigo`, `nombre`) 
VALUES ('40','0.05','0.01','0.04','MCL36','McLaren');

INSERT INTO `formula1`.`t_coches` (`consumo`, `ers_curva_lenta`, `ers_curva_media`, `ers_curva_rapida`,`codigo`, `nombre`) 
VALUES ('45','0.02','0.01','0.03','A522','Alpine');

INSERT INTO `formula1`.`t_coches` (`consumo`, `ers_curva_lenta`, `ers_curva_media`, `ers_curva_rapida`,`codigo`, `nombre`) 
VALUES ('45','0.03','0.02','0.06','AT03','AlphaTauri');

INSERT INTO `formula1`.`t_coches` (`consumo`, `ers_curva_lenta`, `ers_curva_media`, `ers_curva_rapida`,`codigo`, `nombre`) 
VALUES ('45','0.02','0.03','0.04','AMR22','Aston Martin');

INSERT INTO `formula1`.`t_coches` (`consumo`, `ers_curva_lenta`, `ers_curva_media`, `ers_curva_rapida`,`codigo`, `nombre`) 
VALUES ('45','0.01','0.05','0.06','FW43B','Williams');

INSERT INTO `formula1`.`t_coches` (`consumo`, `ers_curva_lenta`, `ers_curva_media`, `ers_curva_rapida`,`codigo`, `nombre`) 
VALUES ('45','0.02','0.05','0.03','C42','Alfa Romeo');

INSERT INTO `formula1`.`t_coches` (`consumo`, `ers_curva_lenta`, `ers_curva_media`, `ers_curva_rapida`,`codigo`, `nombre`) 
VALUES ('45','0.05','0.05','0.06','VF-22','Haas');

#6 Tabla t_circuitos

INSERT INTO `formula1`.`t_circuitos` (`ciudad`, `curvas_lentas`, `curvas_medias`, `curvas_rapidas`, `longitud`, `nombre`, `numero_de_vueltas`, `pais`, `trazado`) 
VALUES ('Spielberg', '2', '1', '1', '4.318', 'GP de Austria', '71', 'Austria', 'https://www.racingcircuits.info/assets/components/phpthumbof/cache/Red-Bull-Ring-2019.b3d6fe06fac602e0386be27f2932c884.png');

INSERT INTO `formula1`.`t_circuitos` (`ciudad`, `curvas_lentas`, `curvas_medias`, `curvas_rapidas`, `longitud`, `nombre`, `numero_de_vueltas`, `pais`, `trazado`)
VALUES ('Francorchamps','1','3','3','7.004','GP de Bélgica','44','Belgica','https://www.racingcircuits.info/assets/components/phpthumbof/cache/SpaF1-07.f8790385e69917207b1a12e00b639228.png');

INSERT INTO `formula1`.`t_circuitos` (`ciudad`, `curvas_lentas`, `curvas_medias`, `curvas_rapidas`, `longitud`, `nombre`, `numero_de_vueltas`, `pais`, `trazado`)
VALUES ('El Algarve','4','2','2','4.653','GP de Portugal','66','Portugal','https://www.racingcircuits.info/assets/components/phpthumbof/cache/Portimao-2021.36614d40a9b5c4073ab69b512393cdda.png');

INSERT INTO `formula1`.`t_circuitos` (`ciudad`, `curvas_lentas`, `curvas_medias`, `curvas_rapidas`, `longitud`, `nombre`, `numero_de_vueltas`, `pais`, `trazado`)
VALUES ('Barcelona','2','2','3','4.675','GP de España','66','España','https://www.racingcircuits.info/assets/components/phpthumbof/cache/Barcelona-2021.a4009a3e108e28ddcae739735d57e446.png');

INSERT INTO `formula1`.`t_circuitos` (`ciudad`, `curvas_lentas`, `curvas_medias`, `curvas_rapidas`, `longitud`, `nombre`, `numero_de_vueltas`, `pais`, `trazado`)
VALUES ('Montecarlo','2','1','2','3.337','GP de Mónaco','78','Mónaco','https://www.racingcircuits.info/assets/components/phpthumbof/cache/Monte-Carlo---2021.e867a7ce7c32e11be3f098fc1af532b8.png');

INSERT INTO `formula1`.`t_circuitos` (`ciudad`, `curvas_lentas`, `curvas_medias`, `curvas_rapidas`, `longitud`, `nombre`, `numero_de_vueltas`, `pais`, `trazado`)
VALUES ('Le Castellet','3','3','1','5.842','GP de Francia','53','Francia','https://www.racingcircuits.info/assets/components/phpthumbof/cache/Paul-Ricard-1A-19.ef687c3b39d9224bbfbb380fdfd49704.png');

INSERT INTO `formula1`.`t_circuitos` (`ciudad`, `curvas_lentas`, `curvas_medias`, `curvas_rapidas`, `longitud`, `nombre`, `numero_de_vueltas`, `pais`, `trazado`)
VALUES ('Zandvoort','1','1','3','4.259','GP de los Países Bajos','72','Países Bajos','https://www.racingcircuits.info/assets/components/phpthumbof/cache/Zandvoort20.b428501ee7d227d7663edc60354f37a0.png');

INSERT INTO `formula1`.`t_circuitos` (`ciudad`, `curvas_lentas`, `curvas_medias`, `curvas_rapidas`, `longitud`, `nombre`, `numero_de_vueltas`, `pais`, `trazado`)
VALUES ('Monza','2','2','1','5.793','GP de Italia','53','Italia','https://www.racingcircuits.info/assets/components/phpthumbof/cache/Monza2010.338442404079e95892772ec79cc64836.png');

INSERT INTO `formula1`.`t_circuitos` (`ciudad`, `curvas_lentas`, `curvas_medias`, `curvas_rapidas`, `longitud`, `nombre`, `numero_de_vueltas`, `pais`, `trazado`)
VALUES ('Montreal','2','3','2','4.361','GP de Canadá','70','Canadá','https://www.racingcircuits.info/assets/components/phpthumbof/cache/Montreal02.e6adc2ec9fb92e60b08655adc6fb4342.png');

INSERT INTO `formula1`.`t_circuitos` (`ciudad`, `curvas_lentas`, `curvas_medias`, `curvas_rapidas`, `longitud`, `nombre`, `numero_de_vueltas`, `pais`, `trazado`)
VALUES ('Ciudad de México','4','3','3','4.304','GP de México','71','México','https://www.racingcircuits.info/assets/components/phpthumbof/cache/Mexico-City-GP-Foro-Sol2020.47e2c55ea0fc645fb34b5885f04efda8.png');

#7 Tabla t_pilotos

INSERT INTO `formula1`.`t_pilotos` (`apellidos`, `dorsal`, `foto`, `nombre`, `pais`, `siglas`, `twitter`) 
VALUES ('Hamilton','44','https://www.pngplay.com/wp-content/uploads/13/Lewis-Hamilton-Transparent-PNG.png','Lewis','Reino Unido','HAM','https://twitter.com/LewisHamilton');

INSERT INTO `formula1`.`t_pilotos` (`apellidos`, `dorsal`, `foto`, `nombre`, `pais`, `siglas`, `twitter`) 
VALUES ('Verstappen','1','https://www.pngplay.com/wp-content/uploads/13/Max-Verstappen-PNG-Clipart-Background.png','Max','Paises Bajos','VER','https://twitter.com/Max33Verstappen');

INSERT INTO `formula1`.`t_pilotos` (`apellidos`, `dorsal`, `foto`, `nombre`, `pais`, `siglas`, `twitter`) 
VALUES ('Sainz','55','https://www.f1fantasytracker.com/Images/Drivers/Sainz.png','Carlos','España','SAI','https://twitter.com/Carlossainz55');

INSERT INTO `formula1`.`t_pilotos` (`apellidos`, `dorsal`, `foto`, `nombre`, `pais`, `siglas`, `twitter`) 
VALUES ('Norris','4','https://www.f1news.fr/wp-content/uploads/2021/03/Nor.png','Lando','Reino Unido','NOR','https://twitter.com/LandoNorris');

INSERT INTO `formula1`.`t_pilotos` (`apellidos`, `dorsal`, `foto`, `nombre`, `pais`, `siglas`, `twitter`) 
VALUES ('Alonso','14','https://www.f1fantasytracker.com/Images//Drivers/2021/AlonsoFull.png','Fernando','España','ALO','https://twitter.com/alo_oficial');

INSERT INTO `formula1`.`t_pilotos` (`apellidos`, `dorsal`, `foto`, `nombre`, `pais`, `siglas`, `twitter`) 
VALUES ('Gasly','10','https://www.f1fantasytracker.com/Images/Drivers/2019/Gasly.png','Pierre','Francia','GAS','https://twitter.com/PierreGASLY');

INSERT INTO `formula1`.`t_pilotos` (`apellidos`, `dorsal`, `foto`, `nombre`, `pais`, `siglas`, `twitter`) 
VALUES ('Vettel','5','https://www.pngarts.com/files/11/Sebastian-Vettel-PNG-Download-Image.png','Sebastian','Alemania','VET','https://twitter.com/sebvettelnews');

INSERT INTO `formula1`.`t_pilotos` (`apellidos`, `dorsal`, `foto`, `nombre`, `pais`, `siglas`, `twitter`) 
VALUES ('Latifi','6','https://e0.365dm.com/f1/drivers/256x256/h_full_1502.png','Nicholas','Canada','LAT','https://twitter.com/NicholasLatifi');

INSERT INTO `formula1`.`t_pilotos` (`apellidos`, `dorsal`, `foto`, `nombre`, `pais`, `siglas`, `twitter`) 
VALUES ('Bottas','77','https://www.f1fantasytracker.com/Images/Drivers/2020/Bottas.png','Valtteri ','Finlandia','BOT','https://twitter.com/ValtteriBottas');

INSERT INTO `formula1`.`t_pilotos` (`apellidos`, `dorsal`, `foto`, `nombre`, `pais`, `siglas`, `twitter`) 
VALUES ('Schumacher','47','https://www.pngplay.com/wp-content/uploads/13/Michael-Schumacher-Background-PNG-Image.png','Mick','Alemania','SCH','https://twitter.com/schumacher');

#8 Tabla t_escuderia

INSERT INTO `formula1`.`t_escuderias` (`logo`, `nombre`, `nombre_responsable`, `twitter`) 
VALUES ('https://upload.wikimedia.org/wikipedia/commons/thumb/9/9b/Mercedes_benz_logo1989.png/800px-Mercedes_benz_logo1989.png','Mercedes','Lewis Hamilton','https://twitter.com/MercedesAMGF1');

INSERT INTO `formula1`.`t_escuderias` (`logo`, `nombre`, `nombre_responsable`, `twitter`)
VALUES ('http://assets.stickpng.com/images/580b57fcd9996e24bc43c1eb.png', 'Red Bull', 'Max Verstappen', 'https://twitter.com/redbullracing');

INSERT INTO `formula1`.`t_escuderias` (`logo`, `nombre`, `nombre_responsable`, `twitter`)
VALUES ('https://www.carlogos.org/car-logos/scuderia-ferrari-logo-800x1050.png', 'Ferrari', 'Carlos Sainz', 'https://twitter.com/ScuderiaFerrari');

INSERT INTO `formula1`.`t_escuderias` (`logo`, `nombre`, `nombre_responsable`, `twitter`)
VALUES ('https://upload.wikimedia.org/wikipedia/fr/b/ba/McLaren_Racing_logo_2021.png', 'McLaren', 'Lando Norris', 'https://twitter.com/McLarenF1');

INSERT INTO `formula1`.`t_escuderias` (`logo`, `nombre`, `nombre_responsable`, `twitter`)
VALUES ('https://upload.wikimedia.org/wikipedia/fr/thumb/b/b7/Alpine_F1_Team_2021_Logo.svg/1200px-Alpine_F1_Team_2021_Logo.svg.png', 'Alpine', 'Fernando Alonso', 'https://twitter.com/AlpineF1Team');

INSERT INTO `formula1`.`t_escuderias` (`logo`, `nombre`, `nombre_responsable`, `twitter`)
VALUES ('https://scuderia.alphatauri.com/wp-content/uploads/2018/10/Scuderia-AlphaTauri-logo-Google.png', 'AlphaTauri', 'Pierre Gasly', 'https://twitter.com/AlphaTauriF1');

INSERT INTO `formula1`.`t_escuderias` (`logo`, `nombre`, `nombre_responsable`, `twitter`)
VALUES ('https://upload.wikimedia.org/wikipedia/fr/f/fe/Logo-AMR-Aston-Martin-racing.png', 'Aston Martin', 'Sebastian Vettel', 'https://twitter.com/AstonMartinF1');

INSERT INTO `formula1`.`t_escuderias` (`logo`, `nombre`, `nombre_responsable`, `twitter`)
VALUES ('https://upload.wikimedia.org/wikipedia/commons/f/f9/Logo_Williams_F1.png', 'Williams', 'Nicholas Latifi', 'https://twitter.com/WilliamsRacing');

INSERT INTO `formula1`.`t_escuderias` (`logo`, `nombre`, `nombre_responsable`, `twitter`)
VALUES ('https://upload.wikimedia.org/wikipedia/en/2/2a/Alfa_Romeo_logo.png', 'Alfa Romeo', 'Valtteri Bottas', 'https://twitter.com/alfaromeoorlen');

INSERT INTO `formula1`.`t_escuderias` (`logo`, `nombre`, `nombre_responsable`, `twitter`)
VALUES ('https://upload.wikimedia.org/wikipedia/commons/thumb/f/f8/Uralkali_Haas_F1_Team_Logo.svg/2560px-Uralkali_Haas_F1_Team_Logo.svg.png', 'Haas', 'Mick Schumacher', 'https://twitter.com/HaasF1Team');

#9 Tabla t_calendario

INSERT INTO `formula1`.`t_calendario` (`ciudad`, `fecha`, `nombre_evento`, `nombre_circuito`, `pais`) 
VALUES ('Spielberg', '2021-01-15', 'GP de Austria', 'GP de Austria', 'Austria');

INSERT INTO `formula1`.`t_calendario` (`ciudad`, `fecha`, `nombre_evento`, `nombre_circuito`, `pais`) 
VALUES ('Francorchamps', '2021-02-15', 'GP de Bélgica', 'GP de Bélgica', 'Belgica');

INSERT INTO `formula1`.`t_calendario` (`ciudad`, `fecha`, `nombre_evento`, `nombre_circuito`, `pais`) 
VALUES ('El Algarve', '2021-03-15', 'GP de Portugal', 'GP de Portugal', 'Portugal');

INSERT INTO `formula1`.`t_calendario` (`ciudad`, `fecha`, `nombre_evento`, `nombre_circuito`, `pais`) 
VALUES ('Barcelona', '2021-04-15', 'GP de España', 'GP de España', 'España');

INSERT INTO `formula1`.`t_calendario` (`ciudad`, `fecha`, `nombre_evento`, `nombre_circuito`, `pais`) 
VALUES ('Montecarlo', '2021-05-15', 'GP de Mónaco', 'GP de Mónaco', 'Mónaco');

INSERT INTO `formula1`.`t_calendario` (`ciudad`, `fecha`, `nombre_evento`, `nombre_circuito`, `pais`) 
VALUES ('Le Castellet', '2021-06-15', 'GP de Francia', 'GP de Francia', 'Francia');

#10 Tabla t_votaciones_form
INSERT INTO `formula1`.`t_votacion_form` (`id_piloto`) 
VALUES ('1');

INSERT INTO `formula1`.`t_votacion_form` (`id_piloto`) 
VALUES ('2');

INSERT INTO `formula1`.`t_votacion_form` (`id_piloto`) 
VALUES ('3');

INSERT INTO `formula1`.`t_votacion_form` (`id_piloto`) 
VALUES ('4');

INSERT INTO `formula1`.`t_votacion_form` (`id_piloto`) 
VALUES ('5');

INSERT INTO `formula1`.`t_votacion_form` (`id_piloto`) 
VALUES ('6');

INSERT INTO `formula1`.`t_votacion_form` (`id_piloto`) 
VALUES ('7');

INSERT INTO `formula1`.`t_votacion_form` (`id_piloto`) 
VALUES ('8');

#11 Tabla t_votaciones
INSERT INTO `formula1`.`t_votaciones` (`correo_votacion`, `nombre_votacion`, `piloto_votado`) 
VALUES ('user1@example.com', 'user1', '1');

INSERT INTO `formula1`.`t_votaciones` (`correo_votacion`, `nombre_votacion`, `piloto_votado`) 
VALUES ('user2@example.com', 'user2', '1');

INSERT INTO `formula1`.`t_votaciones` (`correo_votacion`, `nombre_votacion`, `piloto_votado`) 
VALUES ('user3@example.com', 'user4', '1');

INSERT INTO `formula1`.`t_votaciones` (`correo_votacion`, `nombre_votacion`, `piloto_votado`) 
VALUES ('user4@example.com', 'user4', '2');

INSERT INTO `formula1`.`t_votaciones` (`correo_votacion`, `nombre_votacion`, `piloto_votado`) 
VALUES ('user5@example.com', 'user5', '2');

INSERT INTO `formula1`.`t_votaciones` (`correo_votacion`, `nombre_votacion`, `piloto_votado`) 
VALUES ('user6@example.com', 'user6', '3');

INSERT INTO `formula1`.`t_votaciones` (`correo_votacion`, `nombre_votacion`, `piloto_votado`) 
VALUES ('user7@example.com', 'user7', '3');

INSERT INTO `formula1`.`t_votaciones` (`correo_votacion`, `nombre_votacion`, `piloto_votado`) 
VALUES ('user8@example.com', 'user8', '3');

INSERT INTO `formula1`.`t_votaciones` (`correo_votacion`, `nombre_votacion`, `piloto_votado`) 
VALUES ('user9@example.com', 'user9', '4');

#12 Tabla evento_circuito

INSERT INTO `formula1`.`evento_circuito` (`id_circuito`, `id_calendario`) VALUES ('1', '1');
INSERT INTO `formula1`.`evento_circuito` (`id_circuito`, `id_calendario`) VALUES ('2', '2');
INSERT INTO `formula1`.`evento_circuito` (`id_circuito`, `id_calendario`) VALUES ('3', '3');
INSERT INTO `formula1`.`evento_circuito` (`id_circuito`, `id_calendario`) VALUES ('4', '4');
INSERT INTO `formula1`.`evento_circuito` (`id_circuito`, `id_calendario`) VALUES ('5', '5');
INSERT INTO `formula1`.`evento_circuito` (`id_circuito`, `id_calendario`) VALUES ('6', '6');

#13 Tabla piloto_escuderia

INSERT INTO `formula1`.`pilotos_escuderia` (`escuderia_id`, `piloto_id`) VALUES ('1', '1');
INSERT INTO `formula1`.`pilotos_escuderia` (`escuderia_id`, `piloto_id`) VALUES ('2', '2');
INSERT INTO `formula1`.`pilotos_escuderia` (`escuderia_id`, `piloto_id`) VALUES ('3', '3');
INSERT INTO `formula1`.`pilotos_escuderia` (`escuderia_id`, `piloto_id`) VALUES ('4', '4');
INSERT INTO `formula1`.`pilotos_escuderia` (`escuderia_id`, `piloto_id`) VALUES ('5', '5');
INSERT INTO `formula1`.`pilotos_escuderia` (`escuderia_id`, `piloto_id`) VALUES ('6', '6');
INSERT INTO `formula1`.`pilotos_escuderia` (`escuderia_id`, `piloto_id`) VALUES ('7', '7');
INSERT INTO `formula1`.`pilotos_escuderia` (`escuderia_id`, `piloto_id`) VALUES ('8', '8');
INSERT INTO `formula1`.`pilotos_escuderia` (`escuderia_id`, `piloto_id`) VALUES ('9', '9');
INSERT INTO `formula1`.`pilotos_escuderia` (`escuderia_id`, `piloto_id`) VALUES ('10', '10');

#14 Tabla coche_escuderia

INSERT INTO `formula1`.`coches_escuderia` (`escuderia_id`, `coche_id`) VALUES ('1', '1');
INSERT INTO `formula1`.`coches_escuderia` (`escuderia_id`, `coche_id`) VALUES ('2', '2');
INSERT INTO `formula1`.`coches_escuderia` (`escuderia_id`, `coche_id`) VALUES ('3', '3');
INSERT INTO `formula1`.`coches_escuderia` (`escuderia_id`, `coche_id`) VALUES ('4', '4');
INSERT INTO `formula1`.`coches_escuderia` (`escuderia_id`, `coche_id`) VALUES ('5', '5');
INSERT INTO `formula1`.`coches_escuderia` (`escuderia_id`, `coche_id`) VALUES ('6', '6');
INSERT INTO `formula1`.`coches_escuderia` (`escuderia_id`, `coche_id`) VALUES ('7', '7');
INSERT INTO `formula1`.`coches_escuderia` (`escuderia_id`, `coche_id`) VALUES ('8', '8');
INSERT INTO `formula1`.`coches_escuderia` (`escuderia_id`, `coche_id`) VALUES ('9', '9');
INSERT INTO `formula1`.`coches_escuderia` (`escuderia_id`, `coche_id`) VALUES ('10', '10');

#15 Tabla users_escuderia
INSERT INTO `formula1`.`users_escuderia`(`escuderia_id`,`user_id`)
VALUES('1','2');
INSERT INTO `formula1`.`users_escuderia`(`escuderia_id`,`user_id`)
VALUES('2','3');
INSERT INTO `formula1`.`users_escuderia`(`escuderia_id`,`user_id`)
VALUES('3','4');


