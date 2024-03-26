# User Sync Tool Cosmos DB

This tool is capable of fetching User data from Azure Cosmos DB and store in the WSO2 Identity Server Database. This Tool acts in co-relationship with an Agent in a Different Cluster which will be writing those User Data To the Cosmos DB.
## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Installation

mvn clean install

mvn exec:java -Dexec.mainClass="com.sync.tool.SyncTool"

## Usage

Use the Build Script with the given instructions.
