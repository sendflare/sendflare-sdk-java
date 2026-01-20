# sendflare-sdk-java

The SDK for sendflare service written in Java.

## Requirements

> Java Version >= 11

## Installation

### Maven

Add this dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>io.sendflare</groupId>
    <artifactId>sendflare-sdk-java</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Gradle

Add this dependency to your `build.gradle`:

```gradle
implementation 'io.sendflare:sendflare-sdk-java:1.0.0'
```

## Code Examples

### Basic Usage

```java
import io.sendflare.sdk.SendflareClient;
import io.sendflare.sdk.model.SendEmailReq;
import io.sendflare.sdk.model.SendEmailResp;

public class Example {
    public static void main(String[] args) {
        SendflareClient client = new SendflareClient("this-is-my-token");
        
        SendEmailReq req = new SendEmailReq(
            "test@example.com",
            "to@example.com",
            "test",
            "test email"
        );
        
        try {
            SendEmailResp resp = client.sendEmail(req);
            System.out.println("Email sent successfully: " + resp.isSuccess());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### Send Email

```java
import io.sendflare.sdk.SendflareClient;
import io.sendflare.sdk.model.SendEmailReq;
import io.sendflare.sdk.model.SendEmailResp;

SendflareClient client = new SendflareClient("your-api-token");

SendEmailReq req = new SendEmailReq(
    "sender@example.com",
    "recipient@example.com",
    "Hello from Sendflare",
    "This is a test email"
);

try {
    SendEmailResp response = client.sendEmail(req);
    if (response.isSuccess()) {
        System.out.println("Email sent successfully!");
    } else {
        System.out.println("Failed to send email: " + response.getMessage());
    }
} catch (IOException | InterruptedException e) {
    e.printStackTrace();
}
```

### Manage Contacts

```java
import io.sendflare.sdk.SendflareClient;
import io.sendflare.sdk.model.*;
import java.util.HashMap;
import java.util.Map;

SendflareClient client = new SendflareClient("your-api-token");

// Save a contact
Map<String, String> contactData = new HashMap<>();
contactData.put("firstName", "John");
contactData.put("lastName", "Doe");

SaveContactReq saveReq = new SaveContactReq(
    "your-app-id",
    "john@example.com",
    contactData
);

try {
    SaveContactResp saveResp = client.saveContact(saveReq);
    System.out.println("Contact saved: " + saveResp.isSuccess());
} catch (Exception e) {
    e.printStackTrace();
}

// Get contact list
ListContactReq listReq = new ListContactReq("your-app-id", 1, 10);

try {
    ListContactResp listResp = client.getContactList(listReq);
    System.out.println("Total contacts: " + listResp.getTotalCount());
    for (ContactItem contact : listResp.getData()) {
        System.out.println("Contact: " + contact.getEmailAddress());
    }
} catch (Exception e) {
    e.printStackTrace();
}

// Delete a contact
DeleteContactReq deleteReq = new DeleteContactReq("john@example.com", "your-app-id");

try {
    DeleteContactResp deleteResp = client.deleteContact(deleteReq);
    System.out.println("Contact deleted: " + deleteResp.isSuccess());
} catch (Exception e) {
    e.printStackTrace();
}
```

## API Reference

### `SendflareClient`

#### Constructor

```java
public SendflareClient(String token)
```

Create a new Sendflare client instance.

**Parameters:**
- `token` - Your Sendflare API token

#### Methods

##### `sendEmail(SendEmailReq req)`

Send an email.

**Parameters:**
- `req` - Send email request
  - `from` - Sender email address
  - `to` - Recipient email address
  - `subject` - Email subject
  - `body` - Email body content

**Returns:** `SendEmailResp`

**Throws:** `IOException`, `InterruptedException`

##### `getContactList(ListContactReq req)`

Get contact list with pagination.

**Parameters:**
- `req` - List contact request
  - `appId` - Application ID
  - `page` - Page number
  - `pageSize` - Number of items per page

**Returns:** `ListContactResp`

**Throws:** `IOException`, `InterruptedException`

##### `saveContact(SaveContactReq req)`

Create or update a contact.

**Parameters:**
- `req` - Save contact request
  - `appId` - Application ID
  - `emailAddress` - Contact email address
  - `data` - Contact data (Map<String, String>)

**Returns:** `SaveContactResp`

**Throws:** `IOException`, `InterruptedException`

##### `deleteContact(DeleteContactReq req)`

Delete a contact.

**Parameters:**
- `req` - Delete contact request
  - `emailAddress` - Contact email address to delete
  - `appId` - Application ID

**Returns:** `DeleteContactResp`

**Throws:** `IOException`, `InterruptedException`

## Model Classes

### Request Models

- `SendEmailReq` - Send email request
- `ListContactReq` - Get contact list request
- `SaveContactReq` - Save contact request
- `DeleteContactReq` - Delete contact request
- `PaginateReq` - Pagination request (base class)

### Response Models

- `SendEmailResp` - Send email response
- `ListContactResp` - Get contact list response
- `SaveContactResp` - Save contact response
- `DeleteContactResp` - Delete contact response
- `CommonResponse<T>` - Common response wrapper
- `PaginateResp` - Pagination response (base class)
- `ContactItem` - Contact information

## Building from Source

```bash
# Clone the repository
git clone https://github.com/sendflare/sendflare-sdk-java.git
cd sendflare-sdk-java

# Build with Maven
mvn clean install

# Run tests
mvn test
```

## Dependencies

- **Gson** (2.10.1) - JSON serialization/deserialization
- **JUnit 5** (5.10.1) - Testing framework (test scope)
- **Java 11+** - Uses HttpClient from java.net.http

## Documentation

[https://docs.sendflare.com](https://docs.sendflare.com)

## LICENSE

[MIT](./LICENSE)

