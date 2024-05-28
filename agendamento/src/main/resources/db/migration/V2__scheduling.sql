CREATE TABLE tbl_collection_schedules (
    schedule_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_id BIGINT NOT NULL,
    collector_name VARCHAR(255),
    status VARCHAR(50),
    scheduled_date DATE,
    CONSTRAINT CHK_status CHECK (status IN ('PENDING', 'COMPLETED', 'CANCELLED'))
);