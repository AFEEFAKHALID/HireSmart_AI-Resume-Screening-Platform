# HireSmart Database

## Database

MySQL 8

## Database Name

hiresmart_db

## Total Tables

32

## Modules

- Authentication
- User Management
- Recruiters
- Companies
- Candidate Profiles
- Education
- Experience
- Projects
- Certifications
- Skills
- Resume Management
- Job Management
- Recruitment Workflow
- AI Resume Analysis
- Notifications
- Reports
- Audit Logs
- Activity Logs
- System Settings

## Import Instructions

1. Create a MySQL database:

```sql
CREATE DATABASE hiresmart_db;
USE hiresmart_db;
```

2. Import the schema:

```sql
SOURCE schema/hiresmart_schema.sql;
```

3. Import the sample data:

```sql
SOURCE seed/sample_data.sql;
```