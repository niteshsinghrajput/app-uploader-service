CREATE TABLE adjustment.adjustment(
    adjustment_id SERIAL PRIMARY KEY,
    adjustment_start_date date NOT NULL,
    adjustment_end_date date NOT NULL,
    available_for_reviewer VARCHAR(5),
    adjustment_status VARCHAR(15) NOT NULL CHECK(adjustment_status IN ('DRAFT', 'SUBMITTED', 'APPROVED','REJECTED', 'EXPORTED', 'UPLOADED')),
    data_extract_id INTEGER NOT NULL, CONSTRAINT fk_adj_extract FOREIGN KEY(data_extract_id)
    REFERENCES adjustment.adjusted_data_extract(data_extract_id));