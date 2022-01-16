CREATE TABLE adjustment.adjustment_field_values(
    record_id serial PRIMARY KEY, adjustment_id INTEGER NOT NULL,
    field_id INTEGER NOT NULL,
    field_value VARCHAR(100),
    CONSTRAINT fk_field_field FOREIGN KEY (field_id) REFERENCES adjustment.adjustment_fields(field_id),
    CONSTRAINT fK_field_adjustment FOREIGN KEY (adjustment_id) REFERENCES adjustment.adjustment(adjustment_id)
);