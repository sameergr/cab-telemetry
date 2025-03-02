import random
import time
import json

def generate_telemetry():
    return {
        "device_id": f"device_{random.randint(1, 10)}",
        "temperature": round(random.uniform(20, 40), 2),
        "humidity": round(random.uniform(30, 70), 2),
        "timestamp": time.time()
    }

while True:
    data = generate_telemetry()
    print(json.dumps(data))  # You can send this to Kafka, MQTT, etc.
    time.sleep(2)
