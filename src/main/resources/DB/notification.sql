CREATE TABLE adjustment.notification(
    notification_id SERIAL PRIMARY KEY,
    notification_text text NOT NULL, notification_type VARCHAR(15) NOT NULL,
    event_id INTEGER NOT NULL,
    CONSTRAINT fk_notification_event FOREIGN KEY(event_id) REFERENCES adjustment.audit_event(event_id)
);