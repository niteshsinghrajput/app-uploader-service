CREATE TABLE adjustment.adjusted_data_extract(
    data_extract_id SERIAL PRIMARY KEY,
    created_time TIMESTAMP WITH TIME ZONE NOT NULL,
    file_location VARCHAR(100),
    upload_time TIMESTAMP WITH TIME ZONE NOT NULL
);