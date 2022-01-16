CREATE TABLE adjustment.audit_event(
    event_id SERIAL PRIMARY KEY, event_date_time TIMESTAMP WITH TIME ZONE NOT NULL,
    adjustment_id INTEGER NOT NULL, adjustment_status VARCHAR(15) NOT NULL CHECK(adjustment_status IN ('DRAFT','SUBMITTED','APPROVED','REJECTED','EXPORTED','UPLOADED')),
    user_id VARCHAR(10), comments text,
    CONSTRAINT fk_user FOREIGN KEY(user_id) REFERENCES adjustment.user(user_id),
    CONSTRAINT fk_audit_adj FOREIGN KEY (adjustment_id) REFERENCES adjustment.adjustment(adjustment_id)
);