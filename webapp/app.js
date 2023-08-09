import React, { useState } from 'react';
import mqtt from 'mqtt';

const App = () => {
  const [button1State, setButton1State] = useState(false);
  const [button2State, setButton2State] = useState(false);
  const [button3State, setButton3State] = useState(false);
  const [button4State, setButton4State] = useState(false);

  const mqttClient = mqtt.connect('mqtt://your-broker-ip', {
    // Add necessary MQTT options here
  });

  const handleButton1Click = () => {
    const newState = !button1State;
    setButton1State(newState);
    mqttClient.publish('plug1/topic', newState ? 'on' : 'off');
  };

  const handleButton2Click = () => {
    // Similar implementation for button 2
  };

  const handleButton3Click = () => {
    // Similar implementation for button 3
  };

  const handleButton4Click = () => {
    // Similar implementation for button 4
  };

  return (
    <div>
      <button onClick={handleButton1Click}>
        {button1State ? 'Turn Off Plug 1' : 'Turn On Plug 1'}
      </button>
      <button onClick={handleButton2Click}>
        {/* Button 2 text */}
      </button>
      <button onClick={handleButton3Click}>
        {/* Button 3 text */}
      </button>
      <button onClick={handleButton4Click}>
        {/* Button 4 text */}
      </button>
    </div>
  );
};

export default App;





// iOS native look
// npm install react react-dom react-native-elements
import React, { useState } from 'react';
import { View, StyleSheet } from 'react-native';
import { Button } from 'react-native-elements';

const App = () => {
  const [button1State, setButton1State] = useState(false);
  // Add similar state and state setters for other buttons

  const handleButton1Click = () => {
    const newState = !button1State;
    setButton1State(newState);
    // Your MQTT publish logic here
  };

  // Add similar button click handlers for other buttons

  return (
    <View style={styles.container}>
      <Button
        title={button1State ? 'Turn Off Plug 1' : 'Turn On Plug 1'}
        onPress={handleButton1Click}
        buttonStyle={styles.button}
        titleStyle={styles.buttonText}
      />
      {/* Add other buttons with similar properties */}
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  button: {
    backgroundColor: '#007AFF', // Blue color similar to iOS native buttons
    marginVertical: 10,
  },
  buttonText: {
    color: 'white', // White text color for contrast
  },
});

export default App;

