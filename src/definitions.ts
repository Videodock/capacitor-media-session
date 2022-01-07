import type { PluginListenerHandle } from '@capacitor/core';

export type MediaState = {
  isPlaying: boolean;
  isActive: boolean;
  title: string;
  subtitle: string;
  artworkUri: string;
  position: number;
}

export type MediaSessionEventType = 'onPlay' | 'onPause' | 'onPausePlay' | 'onStop' | 'onNext' | 'onPrev' | 'onFastForward' | 'onRewind';
export type MediaSessionEvent = { eventName: MediaSessionEventType };
export type MediaSessionListenerFunc = (event: MediaSessionEvent) => void;

export interface CapacitorMediaSessionPlugin {
  initMediaSession(mediaState: MediaState): Promise<{ call: string }>;
  releaseMediaSession(): Promise<{ call: string }>;
  setMediaState(mediaState: MediaState): Promise<{ call: string, mediaState: MediaState }>;

  addListener(eventName: 'mediaSessionEvent', listenerFunc: MediaSessionListenerFunc): Promise<PluginListenerHandle> & PluginListenerHandle;
}
