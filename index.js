import React from 'react';
import {AppRegistry, StyleSheet, Text, View, Button, NativeModules, NativeEventEmitter} from 'react-native';

const { MyReactNativeModule } = NativeModules;
const eventEmitter = new NativeEventEmitter(MyReactNativeModule);

const HelloWorld = () => {

  const handleClose = () => {
    eventEmitter.emit('closeActivity', {});
  };

  return (
    <View style={styles.container}>
      <Text style={styles.hello}>Hello, World from react native side</Text>
      <Button title="Fermer" onPress={handleClose} />
    </View>
  );
};
const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    gap: 40,
    paddingHorizontal: 20,
  },
  hello: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
});

AppRegistry.registerComponent(
  'MyReactNativeApp',
  () => HelloWorld,
);