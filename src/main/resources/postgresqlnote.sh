#connexion 
sudo -iu postgres

#creation de base de donnée
CREATE DATABASE name_of_bd

#lister les bases de données
\l

#connexion a une base de donnée
\c name_of_bd

#creation de table employes
CREATE TABLE employees (id SERIAL PRIMARY KEY, 
	first_name VARCHAR(50), 
	LAST_NAME VARCHAR(50), 
	email VARCHAR(100) UNIQUE, 
	phone_number VARCHAR(15), 
	birth_daye DATE, 
	salary NUMERIC(10,2), 
	departement VARCHAR(50)
);

#lister les tables
\dt

#inserer les données dans la table
INSERT INTO employees ( 
        first_name, 
        LAST_NAME, 
        email, 
        phone_number, 
        birth_daye, 
        salary, 
        departement
) VALUES ('John', 'Doe',  'johndoe@exemple.sn', '773427621', '2023-09-01', 60000.00, 'Engineering');

#lister les donnée
SELECT *FROM employees;

#modifier le mot de passe utilisateur postgres
\password postgres

#quiter l'invite utilisateur postgres
\q

#quiter l'invite  de commande
exit
