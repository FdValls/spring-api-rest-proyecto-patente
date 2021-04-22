CREATE SCHEMA `Registro_Patentes` ;

use Registro_Patentes;

CREATE TABLE patente (
    NroPatente varchar(40),
    id bigint unique auto_increment,
    PRIMARY KEY (id)
);

select * from patente;

INSERT INTO patente (NroPatente)
VALUES
    ('DER293'),
    ('EHK284'),
    ('AC820CF'),
	('AB180LT');
