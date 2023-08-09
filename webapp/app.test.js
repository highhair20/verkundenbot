// App.test.js (The test file for the React app)

import React from 'react';
import { render, fireEvent } from '@testing-library/react';
import App from '../App';

jest.mock('mqtt'); // Mock the MQTT module

describe('App', () => {
  test('should toggle button text and call mqtt.publish when button is clicked', () => {
    // Render the app
    const { getByText } = render(<App />);

    // Get the button element
    const buttonElement = getByText('Turn On Plug 1');

    // Click the button
    fireEvent.click(buttonElement);

    // Expect button text to be updated
    expect(buttonElement.textContent).toBe('Turn Off Plug 1');
    
    // Expect mqtt.publish to be called with the correct parameters
    expect(mqttClient.publish).toHaveBeenCalledWith('plug1/topic', 'on');
  });
});
