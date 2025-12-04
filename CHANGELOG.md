# Changelog

All notable changes to this project will be documented in this file.

## [1.0.0] - 2025-12-02

### Added
- Initial release of Sendflare Java SDK
- Core functionality:
  - `sendEmail()` - Send emails via Sendflare API
  - `getContactList()` - Retrieve contact list with pagination
  - `saveContact()` - Create or update contacts
  - `deleteContact()` - Remove contacts from the system
- Complete Java model classes with proper encapsulation
- JUnit 5 test suite
- Maven build configuration
- Comprehensive documentation

### Features
- **Java 11+ Support**: Uses modern HttpClient API
- **Type Safety**: Strong typing with Java model classes
- **JSON Processing**: Gson library for serialization/deserialization
- **Timeout Handling**: Built-in 10-second timeout for all requests
- **Maven Integration**: Easy dependency management

### Requirements
- Java >= 11
- Maven 3.6+ or Gradle 7.0+

### API Compatibility
- Compatible with Sendflare API v1
- Maintains same request/response contract as Go SDK
- Field names follow camelCase convention (JSON standard)

[1.0.0]: https://github.com/sendflare/sendflare-sdk-java/releases/tag/v1.0.0

