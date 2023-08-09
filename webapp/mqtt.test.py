// mqttHandler.js (The module that handles MQTT communication)

import mqtt from 'mqtt';

const mqttClient = mqtt.connect('mqtt://your-broker-ip', {
  // Add necessary MQTT options here
});

export const toggleSmartPlug = (plugId, status) => {
  const topic = `plug${plugId}/topic`;
  mqttClient.publish(topic, status ? 'on' : 'off');
};

// __tests__/mqttHandler.test.js (The test file)

import { toggleSmartPlug } from '../mqttHandler';
import mqtt from 'mqtt';

jest.mock('mqtt');

describe('toggleSmartPlug', () => {
  beforeEach(() => {
    // Clear all instances and calls to constructor and methods of the mocked MQTT client
    mqtt.connect.mockClear();
    mqttClient.publish.mockClear();
  });

  test('should publish the correct message to turn on the smart plug', () => {
    const plugId = 1;
    const status = true;
    toggleSmartPlug(plugId, status);
    expect(mqttClient.publish).toHaveBeenCalledWith(`plug${plugId}/topic`, 'on');
  });

  test('should publish the correct message to turn off the smart plug', () => {
    const plugId = 2;
    const status = false;
    toggleSmartPlug(plugId, status);
    expect(mqttClient.publish).toHaveBeenCalledWith(`plug${plugId}/topic`, 'off');
  });
});
