use Registro_Patentes; 

SELECT * FROM Registro_Patentes.patente;

CREATE TABLE patente (
    NroPatente varchar(40),
    id bigint
);

INSERT INTO patente (NroPatente)
VALUES
    ('DER293'),
    ('EHK284'),
    ('AC820CF'),
	('AB180LT');