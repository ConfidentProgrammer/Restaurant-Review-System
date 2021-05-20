CREATE TABLE review(
id LONG PRIMARY KEY AUTO_INCREMENT,
restaurantName VARCHAR(255),
review VARCHAR(255),
reviewDate DATE,
reviewTime TIME
);

INSERT INTO review(restaurantName, review, reviewDate, reviewTime) VALUES
('Udupi', 'best resaturant for the south indian', '2020-01-31', '02:00:00'),
('Pizza Pizza', 'Great paneer pizza here', '2020-07-06', '05:00:00'),
('Honest', 'oofff Kinda goodQ', '2020-09-12', '04:32:00');
