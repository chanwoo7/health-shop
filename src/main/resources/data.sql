-- 관리자 계정 생성 (아이디: admin, 비밀번호: admin)
INSERT INTO member (is_active, member_id, reg_date, login_id, name, password)
VALUES (TRUE, 1, '2024-01-01 00:00:00.000000', 'admin', '관리자', '$2a$10$2HytlCWentHkzOtTeb2z5.GUbAsmuBdhlJ/aPOQNtYhfCOOGDzR7O');