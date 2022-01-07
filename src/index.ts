import { registerPlugin } from '@capacitor/core';

import type { CapacitorMediaSessionPlugin } from './definitions';

const CapacitorMediaSession = registerPlugin<CapacitorMediaSessionPlugin>(
  'CapacitorMediaSession',
  {
    web: () => import('./web').then(m => new m.CapacitorMediaSessionWeb()),
  },
);

export * from './definitions';
export { CapacitorMediaSession };
