# Read Me First
The following was discovered as part of building this project:

* The original package name 'com.telemetry.info.iot-telemetry' is invalid and this project uses 'com.telemetry.info.iot_telemetry' instead.

# Getting Started


### Before ingesting data into elastic search create mapping and add a new field of type geo_point and map with location field
PUT /live-cab-position-enriched
{
    "mappings": {
        "properties": {
            "location": { "type": "geo_point" }  // ✅ Correct geo_point mapping
        }
    }
}

### Sink Connector Execute
curl -X POST -H "Content-Type: application/json" --data @Git\ Repos/iot-telemetry/elasticsearch-sink.json http://localhost:8083/connectors

Check Sink Connector Status: http://localhost:8083/connectors/elasticsearch-sink/status

### Check Schema Registry Status
http://localhost:8081/subjects

### Check all available indices
GET _cat/indices?v

### Check field mappings/datatype of index
GET /live-cab-position-enriched/_mapping