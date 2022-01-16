CREATE TABLE adjustment.adjustment_user(
    adjustment_id INTEGER NOT NULL, user_id VARCHAR(10) NOT NULL,
    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES adjustment.user(user_id),
    CONSTRAINT fk_adjustment_id FOREIGN KEY (adjustment_id) REFERENCES adjustment.adjustment(adjustment_id)
);