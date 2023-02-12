CREATE TABLE symbol (
	id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE change_rate (
	id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	symbol_from INTEGER NOT NULL,
	symbol_to INTEGER NOT NULL,
	change_rate INTEGER NOT NULL,
	UNIQUE (symbol_from, symbol_to),
	CONSTRAINT symbol_from
      FOREIGN KEY(symbol_from) 
	  REFERENCES symbol(id),
	CONSTRAINT symbol_to
      FOREIGN KEY(symbol_to) 
	  REFERENCES symbol(id)
);

INSERT INTO symbol(name)
VALUES ('EUR');

INSERT INTO symbol(name)
VALUES ('HUF');
