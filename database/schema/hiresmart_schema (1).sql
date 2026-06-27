-- MySQL dump 10.13  Distrib 8.0.46, for Win64 (x86_64)
--
-- Host: localhost    Database: hiresmart_db
-- ------------------------------------------------------
-- Server version	8.0.46

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `activity_logs`
--

DROP TABLE IF EXISTS `activity_logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activity_logs` (
  `activity_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `activity` varchar(255) DEFAULT NULL,
  `activity_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `ip_address` varchar(50) DEFAULT NULL,
  `browser` varchar(255) DEFAULT NULL,
  `operating_system` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`activity_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `activity_logs_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity_logs`
--

LOCK TABLES `activity_logs` WRITE;
/*!40000 ALTER TABLE `activity_logs` DISABLE KEYS */;
INSERT INTO `activity_logs` VALUES (1,1,'Logged into HireSmart','2026-06-27 21:28:37','192.168.1.10','Google Chrome','Windows 11');
/*!40000 ALTER TABLE `activity_logs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ai_scores`
--

DROP TABLE IF EXISTS `ai_scores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ai_scores` (
  `score_id` int NOT NULL AUTO_INCREMENT,
  `analysis_id` int NOT NULL,
  `ats_score` decimal(5,2) DEFAULT NULL,
  `skill_score` decimal(5,2) DEFAULT NULL,
  `experience_score` decimal(5,2) DEFAULT NULL,
  `education_score` decimal(5,2) DEFAULT NULL,
  `keyword_score` decimal(5,2) DEFAULT NULL,
  `formatting_score` decimal(5,2) DEFAULT NULL,
  `overall_score` decimal(5,2) DEFAULT NULL,
  `generated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`score_id`),
  KEY `analysis_id` (`analysis_id`),
  CONSTRAINT `ai_scores_ibfk_1` FOREIGN KEY (`analysis_id`) REFERENCES `resume_analysis` (`analysis_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ai_scores`
--

LOCK TABLES `ai_scores` WRITE;
/*!40000 ALTER TABLE `ai_scores` DISABLE KEYS */;
INSERT INTO `ai_scores` VALUES (3,2,91.00,94.00,88.00,90.00,92.00,95.00,91.67,'2026-06-27 21:25:59');
/*!40000 ALTER TABLE `ai_scores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `application_status_history`
--

DROP TABLE IF EXISTS `application_status_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `application_status_history` (
  `history_id` int NOT NULL AUTO_INCREMENT,
  `application_id` int NOT NULL,
  `previous_status` varchar(50) DEFAULT NULL,
  `new_status` varchar(50) DEFAULT NULL,
  `changed_by` int DEFAULT NULL,
  `change_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `remarks` text,
  PRIMARY KEY (`history_id`),
  KEY `application_id` (`application_id`),
  KEY `changed_by` (`changed_by`),
  CONSTRAINT `application_status_history_ibfk_1` FOREIGN KEY (`application_id`) REFERENCES `applications` (`application_id`) ON DELETE CASCADE,
  CONSTRAINT `application_status_history_ibfk_2` FOREIGN KEY (`changed_by`) REFERENCES `users` (`user_id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application_status_history`
--

LOCK TABLES `application_status_history` WRITE;
/*!40000 ALTER TABLE `application_status_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `application_status_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `applications`
--

DROP TABLE IF EXISTS `applications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `applications` (
  `application_id` int NOT NULL AUTO_INCREMENT,
  `candidate_id` int NOT NULL,
  `job_id` int NOT NULL,
  `resume_id` int DEFAULT NULL,
  `application_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `application_status` enum('APPLIED','UNDER_REVIEW','SHORTLISTED','INTERVIEW','OFFERED','HIRED','REJECTED','WITHDRAWN') DEFAULT 'APPLIED',
  `cover_letter` text,
  `notes` text,
  PRIMARY KEY (`application_id`),
  KEY `candidate_id` (`candidate_id`),
  KEY `job_id` (`job_id`),
  KEY `resume_id` (`resume_id`),
  CONSTRAINT `applications_ibfk_1` FOREIGN KEY (`candidate_id`) REFERENCES `candidates` (`candidate_id`) ON DELETE CASCADE,
  CONSTRAINT `applications_ibfk_2` FOREIGN KEY (`job_id`) REFERENCES `jobs` (`job_id`) ON DELETE CASCADE,
  CONSTRAINT `applications_ibfk_3` FOREIGN KEY (`resume_id`) REFERENCES `resumes` (`resume_id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applications`
--

LOCK TABLES `applications` WRITE;
/*!40000 ALTER TABLE `applications` DISABLE KEYS */;
INSERT INTO `applications` VALUES (2,1,1,1,'2026-06-27 21:20:02','APPLIED','I am excited to apply for this opportunity.',NULL);
/*!40000 ALTER TABLE `applications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `audit_logs`
--

DROP TABLE IF EXISTS `audit_logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `audit_logs` (
  `audit_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `action` varchar(255) DEFAULT NULL,
  `table_name` varchar(100) DEFAULT NULL,
  `record_id` int DEFAULT NULL,
  `old_value` longtext,
  `new_value` longtext,
  `action_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`audit_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `audit_logs_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audit_logs`
--

LOCK TABLES `audit_logs` WRITE;
/*!40000 ALTER TABLE `audit_logs` DISABLE KEYS */;
INSERT INTO `audit_logs` VALUES (1,1,'INSERT','jobs',1,NULL,'Created Java Developer Job','2026-06-27 21:28:44');
/*!40000 ALTER TABLE `audit_logs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `candidate_profiles`
--

DROP TABLE IF EXISTS `candidate_profiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `candidate_profiles` (
  `profile_id` int NOT NULL AUTO_INCREMENT,
  `candidate_id` int NOT NULL,
  `date_of_birth` date DEFAULT NULL,
  `gender` enum('MALE','FEMALE','OTHER') DEFAULT NULL,
  `nationality` varchar(100) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
  `state` varchar(100) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `address` text,
  `postal_code` varchar(20) DEFAULT NULL,
  `bio` text,
  `profile_photo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`profile_id`),
  UNIQUE KEY `candidate_id` (`candidate_id`),
  CONSTRAINT `candidate_profiles_ibfk_1` FOREIGN KEY (`candidate_id`) REFERENCES `candidates` (`candidate_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidate_profiles`
--

LOCK TABLES `candidate_profiles` WRITE;
/*!40000 ALTER TABLE `candidate_profiles` DISABLE KEYS */;
INSERT INTO `candidate_profiles` VALUES (1,1,'2001-08-10','MALE','American','USA','Georgia','Atlanta','123 Main Street','30301','Passionate Full Stack Developer',NULL);
/*!40000 ALTER TABLE `candidate_profiles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `candidate_skills`
--

DROP TABLE IF EXISTS `candidate_skills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `candidate_skills` (
  `id` int NOT NULL AUTO_INCREMENT,
  `candidate_id` int NOT NULL,
  `skill_id` int NOT NULL,
  `proficiency` enum('BEGINNER','INTERMEDIATE','ADVANCED','EXPERT') DEFAULT 'BEGINNER',
  `years_of_experience` decimal(3,1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `candidate_id` (`candidate_id`),
  KEY `skill_id` (`skill_id`),
  CONSTRAINT `candidate_skills_ibfk_1` FOREIGN KEY (`candidate_id`) REFERENCES `candidates` (`candidate_id`) ON DELETE CASCADE,
  CONSTRAINT `candidate_skills_ibfk_2` FOREIGN KEY (`skill_id`) REFERENCES `skills` (`skill_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidate_skills`
--

LOCK TABLES `candidate_skills` WRITE;
/*!40000 ALTER TABLE `candidate_skills` DISABLE KEYS */;
INSERT INTO `candidate_skills` VALUES (1,1,1,'ADVANCED',2.0),(2,1,2,'ADVANCED',2.0),(3,1,3,'INTERMEDIATE',1.0),(4,1,4,'INTERMEDIATE',2.0);
/*!40000 ALTER TABLE `candidate_skills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `candidates`
--

DROP TABLE IF EXISTS `candidates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `candidates` (
  `candidate_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `profile_completed` tinyint(1) DEFAULT '0',
  `current_job_title` varchar(150) DEFAULT NULL,
  `total_experience` decimal(4,1) DEFAULT NULL,
  `expected_salary` decimal(10,2) DEFAULT NULL,
  `current_salary` decimal(10,2) DEFAULT NULL,
  `notice_period` int DEFAULT NULL,
  `availability` enum('IMMEDIATE','15_DAYS','30_DAYS','60_DAYS') DEFAULT '30_DAYS',
  `willing_to_relocate` tinyint(1) DEFAULT '0',
  `open_to_remote` tinyint(1) DEFAULT '1',
  `linkedin_url` varchar(255) DEFAULT NULL,
  `github_url` varchar(255) DEFAULT NULL,
  `portfolio_url` varchar(255) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`candidate_id`),
  UNIQUE KEY `user_id` (`user_id`),
  CONSTRAINT `fk_candidate_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidates`
--

LOCK TABLES `candidates` WRITE;
/*!40000 ALTER TABLE `candidates` DISABLE KEYS */;
INSERT INTO `candidates` VALUES (1,1,1,'Java Developer',2.0,70000.00,50000.00,30,'30_DAYS',1,1,'https://linkedin.com/in/johnsmith','https://github.com/johnsmith','https://johnsmith.dev','2026-06-27 21:18:10','2026-06-27 21:18:10');
/*!40000 ALTER TABLE `candidates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `certifications`
--

DROP TABLE IF EXISTS `certifications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `certifications` (
  `certification_id` int NOT NULL AUTO_INCREMENT,
  `candidate_id` int NOT NULL,
  `certification_name` varchar(200) DEFAULT NULL,
  `issuing_organization` varchar(200) DEFAULT NULL,
  `issue_date` date DEFAULT NULL,
  `expiry_date` date DEFAULT NULL,
  `credential_id` varchar(100) DEFAULT NULL,
  `credential_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`certification_id`),
  KEY `candidate_id` (`candidate_id`),
  CONSTRAINT `certifications_ibfk_1` FOREIGN KEY (`candidate_id`) REFERENCES `candidates` (`candidate_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `certifications`
--

LOCK TABLES `certifications` WRITE;
/*!40000 ALTER TABLE `certifications` DISABLE KEYS */;
/*!40000 ALTER TABLE `certifications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `companies`
--

DROP TABLE IF EXISTS `companies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `companies` (
  `company_id` int NOT NULL AUTO_INCREMENT,
  `company_name` varchar(150) NOT NULL,
  `company_email` varchar(150) DEFAULT NULL,
  `company_phone` varchar(30) DEFAULT NULL,
  `website` varchar(255) DEFAULT NULL,
  `industry` varchar(100) DEFAULT NULL,
  `company_size` enum('1-10','11-50','51-200','201-500','500+') DEFAULT NULL,
  `founded_year` year DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
  `state` varchar(100) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `address` text,
  `logo` varchar(255) DEFAULT NULL,
  `description` text,
  `status` enum('ACTIVE','INACTIVE') DEFAULT 'ACTIVE',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`company_id`),
  UNIQUE KEY `company_email` (`company_email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `companies`
--

LOCK TABLES `companies` WRITE;
/*!40000 ALTER TABLE `companies` DISABLE KEYS */;
INSERT INTO `companies` VALUES (1,'HireSmart Technologies','info@hiresmart.com','+1 404-555-9876','www.hiresmart.com','Software','51-200',2020,'USA','Georgia','Atlanta','123 Tech Street',NULL,'AI Recruitment Software Company','ACTIVE','2026-06-27 20:53:56','2026-06-27 20:53:56');
/*!40000 ALTER TABLE `companies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `education`
--

DROP TABLE IF EXISTS `education`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `education` (
  `education_id` int NOT NULL AUTO_INCREMENT,
  `candidate_id` int NOT NULL,
  `degree` varchar(150) DEFAULT NULL,
  `institution` varchar(200) DEFAULT NULL,
  `field_of_study` varchar(150) DEFAULT NULL,
  `cgpa` varchar(20) DEFAULT NULL,
  `start_year` year DEFAULT NULL,
  `end_year` year DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`education_id`),
  KEY `candidate_id` (`candidate_id`),
  CONSTRAINT `education_ibfk_1` FOREIGN KEY (`candidate_id`) REFERENCES `candidates` (`candidate_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `education`
--

LOCK TABLES `education` WRITE;
/*!40000 ALTER TABLE `education` DISABLE KEYS */;
INSERT INTO `education` VALUES (1,1,'BS Computer Science','Georgia Tech','Computer Science','3.85',2020,2024,NULL);
/*!40000 ALTER TABLE `education` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `experience`
--

DROP TABLE IF EXISTS `experience`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `experience` (
  `experience_id` int NOT NULL AUTO_INCREMENT,
  `candidate_id` int NOT NULL,
  `company_name` varchar(150) DEFAULT NULL,
  `designation` varchar(150) DEFAULT NULL,
  `employment_type` enum('FULL_TIME','PART_TIME','INTERNSHIP','CONTRACT','FREELANCE') DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `currently_working` tinyint(1) DEFAULT '0',
  `responsibilities` text,
  PRIMARY KEY (`experience_id`),
  KEY `candidate_id` (`candidate_id`),
  CONSTRAINT `experience_ibfk_1` FOREIGN KEY (`candidate_id`) REFERENCES `candidates` (`candidate_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `experience`
--

LOCK TABLES `experience` WRITE;
/*!40000 ALTER TABLE `experience` DISABLE KEYS */;
INSERT INTO `experience` VALUES (1,1,'ABC Technologies','Software Engineer','FULL_TIME','2024-01-01',NULL,1,'Develop enterprise Java applications');
/*!40000 ALTER TABLE `experience` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interview_feedback`
--

DROP TABLE IF EXISTS `interview_feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `interview_feedback` (
  `feedback_id` int NOT NULL AUTO_INCREMENT,
  `interview_id` int NOT NULL,
  `technical_score` decimal(5,2) DEFAULT NULL,
  `communication_score` decimal(5,2) DEFAULT NULL,
  `problem_solving_score` decimal(5,2) DEFAULT NULL,
  `cultural_fit_score` decimal(5,2) DEFAULT NULL,
  `overall_score` decimal(5,2) DEFAULT NULL,
  `strengths` text,
  `weaknesses` text,
  `recommendation` enum('STRONGLY_RECOMMEND','RECOMMEND','MAYBE','REJECT') DEFAULT NULL,
  `comments` text,
  `submitted_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`feedback_id`),
  KEY `interview_id` (`interview_id`),
  CONSTRAINT `interview_feedback_ibfk_1` FOREIGN KEY (`interview_id`) REFERENCES `interviews` (`interview_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interview_feedback`
--

LOCK TABLES `interview_feedback` WRITE;
/*!40000 ALTER TABLE `interview_feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `interview_feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interviews`
--

DROP TABLE IF EXISTS `interviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `interviews` (
  `interview_id` int NOT NULL AUTO_INCREMENT,
  `application_id` int NOT NULL,
  `recruiter_id` int NOT NULL,
  `interview_type` enum('ONLINE','ONSITE','PHONE') DEFAULT 'ONLINE',
  `interview_round` varchar(100) DEFAULT NULL,
  `interview_date` datetime DEFAULT NULL,
  `duration_minutes` int DEFAULT NULL,
  `meeting_link` varchar(255) DEFAULT NULL,
  `interview_location` varchar(255) DEFAULT NULL,
  `interview_status` enum('SCHEDULED','COMPLETED','CANCELLED','RESCHEDULED') DEFAULT 'SCHEDULED',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`interview_id`),
  KEY `application_id` (`application_id`),
  KEY `recruiter_id` (`recruiter_id`),
  CONSTRAINT `interviews_ibfk_1` FOREIGN KEY (`application_id`) REFERENCES `applications` (`application_id`) ON DELETE CASCADE,
  CONSTRAINT `interviews_ibfk_2` FOREIGN KEY (`recruiter_id`) REFERENCES `recruiters` (`recruiter_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interviews`
--

LOCK TABLES `interviews` WRITE;
/*!40000 ALTER TABLE `interviews` DISABLE KEYS */;
/*!40000 ALTER TABLE `interviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job_categories`
--

DROP TABLE IF EXISTS `job_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `job_categories` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(100) NOT NULL,
  `description` text,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`category_id`),
  UNIQUE KEY `category_name` (`category_name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_categories`
--

LOCK TABLES `job_categories` WRITE;
/*!40000 ALTER TABLE `job_categories` DISABLE KEYS */;
INSERT INTO `job_categories` VALUES (1,'Software Development','Software engineering jobs','2026-06-27 21:05:23'),(2,'Artificial Intelligence','AI and ML jobs','2026-06-27 21:05:23'),(3,'Data Science','Data analysis and data science','2026-06-27 21:05:23'),(4,'Cyber Security','Security related jobs','2026-06-27 21:05:23'),(5,'Cloud Computing','AWS Azure GCP','2026-06-27 21:05:23'),(6,'Networking','Network administration','2026-06-27 21:05:23'),(7,'DevOps','CI/CD and Infrastructure','2026-06-27 21:05:23'),(8,'UI/UX','Design jobs','2026-06-27 21:05:23'),(9,'Mobile Development','Android and iOS','2026-06-27 21:05:23'),(10,'Database Administration','Database related jobs','2026-06-27 21:05:23');
/*!40000 ALTER TABLE `job_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job_skills`
--

DROP TABLE IF EXISTS `job_skills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `job_skills` (
  `id` int NOT NULL AUTO_INCREMENT,
  `job_id` int NOT NULL,
  `skill_id` int NOT NULL,
  `required_level` enum('BEGINNER','INTERMEDIATE','ADVANCED','EXPERT') DEFAULT 'INTERMEDIATE',
  `mandatory` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `job_id` (`job_id`),
  KEY `skill_id` (`skill_id`),
  CONSTRAINT `job_skills_ibfk_1` FOREIGN KEY (`job_id`) REFERENCES `jobs` (`job_id`) ON DELETE CASCADE,
  CONSTRAINT `job_skills_ibfk_2` FOREIGN KEY (`skill_id`) REFERENCES `skills` (`skill_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_skills`
--

LOCK TABLES `job_skills` WRITE;
/*!40000 ALTER TABLE `job_skills` DISABLE KEYS */;
INSERT INTO `job_skills` VALUES (1,1,1,'ADVANCED',1),(2,1,2,'ADVANCED',1),(3,1,3,'INTERMEDIATE',1),(4,1,6,'INTERMEDIATE',1);
/*!40000 ALTER TABLE `job_skills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobs`
--

DROP TABLE IF EXISTS `jobs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jobs` (
  `job_id` int NOT NULL AUTO_INCREMENT,
  `recruiter_id` int NOT NULL,
  `company_id` int NOT NULL,
  `category_id` int NOT NULL,
  `job_title` varchar(200) NOT NULL,
  `job_description` longtext,
  `responsibilities` longtext,
  `qualifications` longtext,
  `experience_required` decimal(3,1) DEFAULT NULL,
  `salary_min` decimal(10,2) DEFAULT NULL,
  `salary_max` decimal(10,2) DEFAULT NULL,
  `employment_type` enum('FULL_TIME','PART_TIME','CONTRACT','INTERNSHIP','REMOTE') DEFAULT NULL,
  `workplace_type` enum('ONSITE','HYBRID','REMOTE') DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
  `state` varchar(100) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `vacancies` int DEFAULT '1',
  `application_deadline` date DEFAULT NULL,
  `status` enum('OPEN','CLOSED','DRAFT') DEFAULT 'OPEN',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`job_id`),
  KEY `fk_job_recruiter` (`recruiter_id`),
  KEY `fk_job_company` (`company_id`),
  KEY `fk_job_category` (`category_id`),
  CONSTRAINT `fk_job_category` FOREIGN KEY (`category_id`) REFERENCES `job_categories` (`category_id`),
  CONSTRAINT `fk_job_company` FOREIGN KEY (`company_id`) REFERENCES `companies` (`company_id`) ON DELETE CASCADE,
  CONSTRAINT `fk_job_recruiter` FOREIGN KEY (`recruiter_id`) REFERENCES `recruiters` (`recruiter_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobs`
--

LOCK TABLES `jobs` WRITE;
/*!40000 ALTER TABLE `jobs` DISABLE KEYS */;
INSERT INTO `jobs` VALUES (1,1,1,1,'Full Stack Java Developer','Develop enterprise web applications','Design Develop Test Deploy','BS Computer Science',2.0,50000.00,70000.00,'FULL_TIME','HYBRID','USA','Georgia','Atlanta',3,'2026-12-31','OPEN','2026-06-27 21:06:03','2026-06-27 21:06:03');
/*!40000 ALTER TABLE `jobs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `keyword_analysis`
--

DROP TABLE IF EXISTS `keyword_analysis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `keyword_analysis` (
  `keyword_id` int NOT NULL AUTO_INCREMENT,
  `analysis_id` int NOT NULL,
  `keyword` varchar(100) DEFAULT NULL,
  `found` tinyint(1) DEFAULT NULL,
  `occurrences` int DEFAULT NULL,
  PRIMARY KEY (`keyword_id`),
  KEY `analysis_id` (`analysis_id`),
  CONSTRAINT `keyword_analysis_ibfk_1` FOREIGN KEY (`analysis_id`) REFERENCES `resume_analysis` (`analysis_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `keyword_analysis`
--

LOCK TABLES `keyword_analysis` WRITE;
/*!40000 ALTER TABLE `keyword_analysis` DISABLE KEYS */;
/*!40000 ALTER TABLE `keyword_analysis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notifications`
--

DROP TABLE IF EXISTS `notifications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notifications` (
  `notification_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `message` text,
  `notification_type` enum('INFO','SUCCESS','WARNING','ERROR') DEFAULT 'INFO',
  `is_read` tinyint(1) DEFAULT '0',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`notification_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `notifications_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notifications`
--

LOCK TABLES `notifications` WRITE;
/*!40000 ALTER TABLE `notifications` DISABLE KEYS */;
INSERT INTO `notifications` VALUES (1,1,'Application Submitted','Your application has been submitted successfully.','SUCCESS',0,'2026-06-27 21:28:28');
/*!40000 ALTER TABLE `notifications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projects`
--

DROP TABLE IF EXISTS `projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `projects` (
  `project_id` int NOT NULL AUTO_INCREMENT,
  `candidate_id` int NOT NULL,
  `project_title` varchar(200) DEFAULT NULL,
  `technologies` text,
  `project_link` varchar(255) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`project_id`),
  KEY `candidate_id` (`candidate_id`),
  CONSTRAINT `projects_ibfk_1` FOREIGN KEY (`candidate_id`) REFERENCES `candidates` (`candidate_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projects`
--

LOCK TABLES `projects` WRITE;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
/*!40000 ALTER TABLE `projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recommendations`
--

DROP TABLE IF EXISTS `recommendations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recommendations` (
  `recommendation_id` int NOT NULL AUTO_INCREMENT,
  `analysis_id` int NOT NULL,
  `recommendation_type` enum('SKILL','FORMAT','EXPERIENCE','EDUCATION','GENERAL') DEFAULT NULL,
  `recommendation_text` text,
  `priority` enum('LOW','MEDIUM','HIGH') DEFAULT 'MEDIUM',
  PRIMARY KEY (`recommendation_id`),
  KEY `analysis_id` (`analysis_id`),
  CONSTRAINT `recommendations_ibfk_1` FOREIGN KEY (`analysis_id`) REFERENCES `resume_analysis` (`analysis_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recommendations`
--

LOCK TABLES `recommendations` WRITE;
/*!40000 ALTER TABLE `recommendations` DISABLE KEYS */;
INSERT INTO `recommendations` VALUES (1,2,'SKILL','Learn Docker for better matching','HIGH'),(2,2,'SKILL','Add AWS Certification','HIGH'),(3,2,'FORMAT','Use a professional resume template','LOW'),(4,2,'GENERAL','Add measurable achievements','MEDIUM');
/*!40000 ALTER TABLE `recommendations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recruiters`
--

DROP TABLE IF EXISTS `recruiters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recruiters` (
  `recruiter_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `company_id` int NOT NULL,
  `designation` varchar(100) DEFAULT NULL,
  `department` varchar(100) DEFAULT NULL,
  `recruiter_type` enum('HR','MANAGER','ADMIN') DEFAULT 'HR',
  `is_primary` tinyint(1) DEFAULT '0',
  `total_jobs_posted` int DEFAULT '0',
  `total_hires` int DEFAULT '0',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`recruiter_id`),
  KEY `fk_recruiter_user` (`user_id`),
  KEY `fk_recruiter_company` (`company_id`),
  CONSTRAINT `fk_recruiter_company` FOREIGN KEY (`company_id`) REFERENCES `companies` (`company_id`) ON DELETE CASCADE,
  CONSTRAINT `fk_recruiter_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recruiters`
--

LOCK TABLES `recruiters` WRITE;
/*!40000 ALTER TABLE `recruiters` DISABLE KEYS */;
INSERT INTO `recruiters` VALUES (1,1,1,'Senior HR Manager','Human Resources','ADMIN',1,0,0,'2026-06-27 20:55:39','2026-06-27 20:55:39');
/*!40000 ALTER TABLE `recruiters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reports`
--

DROP TABLE IF EXISTS `reports`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reports` (
  `report_id` int NOT NULL AUTO_INCREMENT,
  `report_name` varchar(200) DEFAULT NULL,
  `report_type` enum('APPLICATION','HIRING','AI','RECRUITMENT','CUSTOM') DEFAULT NULL,
  `generated_by` int DEFAULT NULL,
  `generated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `report_file` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`report_id`),
  KEY `generated_by` (`generated_by`),
  CONSTRAINT `reports_ibfk_1` FOREIGN KEY (`generated_by`) REFERENCES `users` (`user_id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reports`
--

LOCK TABLES `reports` WRITE;
/*!40000 ALTER TABLE `reports` DISABLE KEYS */;
INSERT INTO `reports` VALUES (1,'Monthly Hiring Report','HIRING',1,'2026-06-27 21:28:53','reports/hiring_report.pdf');
/*!40000 ALTER TABLE `reports` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resume_analysis`
--

DROP TABLE IF EXISTS `resume_analysis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resume_analysis` (
  `analysis_id` int NOT NULL AUTO_INCREMENT,
  `application_id` int NOT NULL,
  `analyzed_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `extracted_text` longtext,
  `total_pages` int DEFAULT NULL,
  `total_words` int DEFAULT NULL,
  `parsing_status` enum('PENDING','PROCESSING','COMPLETED','FAILED') DEFAULT 'PENDING',
  `parser_version` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`analysis_id`),
  KEY `application_id` (`application_id`),
  CONSTRAINT `resume_analysis_ibfk_1` FOREIGN KEY (`application_id`) REFERENCES `applications` (`application_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resume_analysis`
--

LOCK TABLES `resume_analysis` WRITE;
/*!40000 ALTER TABLE `resume_analysis` DISABLE KEYS */;
INSERT INTO `resume_analysis` VALUES (2,2,'2026-06-27 21:23:49','Experienced Java Developer with Spring Boot and React',2,640,'COMPLETED','1.0');
/*!40000 ALTER TABLE `resume_analysis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resumes`
--

DROP TABLE IF EXISTS `resumes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resumes` (
  `resume_id` int NOT NULL AUTO_INCREMENT,
  `candidate_id` int NOT NULL,
  `resume_title` varchar(200) DEFAULT NULL,
  `original_file_name` varchar(255) DEFAULT NULL,
  `stored_file_name` varchar(255) DEFAULT NULL,
  `file_path` varchar(500) DEFAULT NULL,
  `file_type` enum('PDF','DOC','DOCX') DEFAULT NULL,
  `file_size` bigint DEFAULT NULL,
  `uploaded_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `is_default` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`resume_id`),
  KEY `candidate_id` (`candidate_id`),
  CONSTRAINT `resumes_ibfk_1` FOREIGN KEY (`candidate_id`) REFERENCES `candidates` (`candidate_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resumes`
--

LOCK TABLES `resumes` WRITE;
/*!40000 ALTER TABLE `resumes` DISABLE KEYS */;
INSERT INTO `resumes` VALUES (1,1,'Software Engineer Resume','resume.pdf','resume_1.pdf','/uploads/resume_1.pdf','PDF',250000,'2026-06-27 21:19:34',1);
/*!40000 ALTER TABLE `resumes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `role_name` (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shortlists`
--

DROP TABLE IF EXISTS `shortlists`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shortlists` (
  `shortlist_id` int NOT NULL AUTO_INCREMENT,
  `application_id` int NOT NULL,
  `recruiter_id` int NOT NULL,
  `shortlisted_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `remarks` text,
  PRIMARY KEY (`shortlist_id`),
  KEY `application_id` (`application_id`),
  KEY `recruiter_id` (`recruiter_id`),
  CONSTRAINT `shortlists_ibfk_1` FOREIGN KEY (`application_id`) REFERENCES `applications` (`application_id`) ON DELETE CASCADE,
  CONSTRAINT `shortlists_ibfk_2` FOREIGN KEY (`recruiter_id`) REFERENCES `recruiters` (`recruiter_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shortlists`
--

LOCK TABLES `shortlists` WRITE;
/*!40000 ALTER TABLE `shortlists` DISABLE KEYS */;
/*!40000 ALTER TABLE `shortlists` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skill_matches`
--

DROP TABLE IF EXISTS `skill_matches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `skill_matches` (
  `match_id` int NOT NULL AUTO_INCREMENT,
  `analysis_id` int NOT NULL,
  `skill_id` int NOT NULL,
  `match_percentage` decimal(5,2) DEFAULT NULL,
  `skill_status` enum('MATCHED','PARTIAL','MISSING') DEFAULT NULL,
  PRIMARY KEY (`match_id`),
  KEY `analysis_id` (`analysis_id`),
  KEY `skill_id` (`skill_id`),
  CONSTRAINT `skill_matches_ibfk_1` FOREIGN KEY (`analysis_id`) REFERENCES `resume_analysis` (`analysis_id`) ON DELETE CASCADE,
  CONSTRAINT `skill_matches_ibfk_2` FOREIGN KEY (`skill_id`) REFERENCES `skills` (`skill_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skill_matches`
--

LOCK TABLES `skill_matches` WRITE;
/*!40000 ALTER TABLE `skill_matches` DISABLE KEYS */;
INSERT INTO `skill_matches` VALUES (1,2,1,100.00,'MATCHED'),(2,2,2,95.00,'MATCHED'),(3,2,3,88.00,'MATCHED'),(4,2,8,0.00,'MISSING');
/*!40000 ALTER TABLE `skill_matches` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skills`
--

DROP TABLE IF EXISTS `skills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `skills` (
  `skill_id` int NOT NULL AUTO_INCREMENT,
  `skill_name` varchar(100) NOT NULL,
  `category` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`skill_id`),
  UNIQUE KEY `skill_name` (`skill_name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skills`
--

LOCK TABLES `skills` WRITE;
/*!40000 ALTER TABLE `skills` DISABLE KEYS */;
INSERT INTO `skills` VALUES (1,'Java','Programming'),(2,'Spring Boot','Backend'),(3,'React','Frontend'),(4,'MySQL','Database'),(5,'Python','Programming'),(6,'Machine Learning','AI'),(7,'JavaScript','Frontend'),(8,'Docker','DevOps'),(9,'AWS','Cloud'),(10,'Git','Version Control');
/*!40000 ALTER TABLE `skills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_settings`
--

DROP TABLE IF EXISTS `system_settings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `system_settings` (
  `setting_id` int NOT NULL AUTO_INCREMENT,
  `setting_key` varchar(150) DEFAULT NULL,
  `setting_value` text,
  `description` text,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`setting_id`),
  UNIQUE KEY `setting_key` (`setting_key`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_settings`
--

LOCK TABLES `system_settings` WRITE;
/*!40000 ALTER TABLE `system_settings` DISABLE KEYS */;
INSERT INTO `system_settings` VALUES (1,'ATS_PASS_SCORE','70','Minimum ATS score','2026-06-27 21:28:17'),(2,'MAX_RESUME_SIZE','5MB','Maximum upload size','2026-06-27 21:28:17'),(3,'ALLOW_DOC_UPLOAD','TRUE','Allow DOC files','2026-06-27 21:28:17'),(4,'ALLOW_DOCX_UPLOAD','TRUE','Allow DOCX files','2026-06-27 21:28:17'),(5,'ALLOW_PDF_UPLOAD','TRUE','Allow PDF files','2026-06-27 21:28:17'),(6,'AI_MODEL','ResumeParser-v1','Current AI Model','2026-06-27 21:28:17');
/*!40000 ALTER TABLE `system_settings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_roles_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE,
  CONSTRAINT `user_roles_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `email` varchar(150) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `profile_image` varchar(255) DEFAULT NULL,
  `account_status` enum('ACTIVE','INACTIVE','BLOCKED') DEFAULT 'ACTIVE',
  `email_verified` tinyint(1) DEFAULT '0',
  `last_login` datetime DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'John','Smith','john@hiresmart.com','123456','+14045551234',NULL,'ACTIVE',1,NULL,'2026-06-27 20:55:13','2026-06-27 20:55:13');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-06-28  2:38:22
