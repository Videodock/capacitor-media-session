import { WebPlugin } from '@capacitor/core';

import type { CapacitorMediaSessionPlugin, MediaState } from './definitions';

export class CapacitorMediaSessionWeb extends WebPlugin implements CapacitorMediaSessionPlugin {
  async initMediaSession (): Promise<{ call: string }> {
    return { call: 'initMediaSession' };
  }

  async releaseMediaSession (): Promise<{ call: string }> {
    return { call: 'releaseMediaSession' };
  }

  async setMediaState (mediaState: MediaState): Promise<{ call: string, mediaState: MediaState }> {
    return { call: 'setMediaState', mediaState };
  }
}
